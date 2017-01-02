package xbp.core.service.system.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xbp.core.base.BaseServiceImpl;
import xbp.core.data.constants.CommonConstants;
import xbp.core.mapper.organization.UserMapper;
import xbp.core.mapper.system.ActionTrackMapper;
import xbp.core.mapper.system.IpAddressesMapper;
import xbp.core.model.system.ActionTrackModel;
import xbp.core.model.system.IpAddressesModel;
import xbp.core.service.system.IActionTrackService;
import xbp.core.util.AddressUtil;
import xbp.core.util.time.TimeUtil;

@Service("ActionTrackService")
public class ActionTrackServiceImpl extends BaseServiceImpl implements IActionTrackService {

    @Autowired
    private ActionTrackMapper actionTrackMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IpAddressesMapper ipAddressesMapper;

    @Override
    public void saveGuestInfro(String ip, ActionTrackModel atm) throws Exception {
        
        // 先查询本地数据库获取地址相关信息
        IpAddressesModel model = ipAddressesMapper.searchById(ip);
        if (model != null) {
            atm.setCountry(model.getIpCountry());
            atm.setProvince(model.getIpProvince());
            atm.setCity(model.getIpCity());
            atm.setArea(model.getIpCounty());
        }
        // 没有再去淘宝那查询
        else {
            Map<String, String> addrmap = AddressUtil.getAddresses(ip, "utf-8");
            if (addrmap != null && !addrmap.isEmpty()) {
                atm.setCountry(addrmap.get("country"));
                atm.setProvince(addrmap.get("region"));
                atm.setCity(addrmap.get("city"));
                atm.setArea(addrmap.get("county"));

                model = new IpAddressesModel();
                model.setIp(ip);
                model.setDeletedFlag(CommonConstants.DELETED_FLAG);
                model.setStatus(CommonConstants.STATUS);
                model.setIpArea(addrmap.get("area"));
                model.setIpCity(addrmap.get("city"));
                model.setIpCountry(addrmap.get("country"));
                model.setIpIsp(addrmap.get("isp"));
                model.setIpProvince(addrmap.get("region"));
                model.setIpCounty(addrmap.get("county"));
                model.setCreateId(getEmployeeId());
                model.setCreateTime(TimeUtil.getSysTimestamp());
                ipAddressesMapper.insert(model);
            }
        }
        actionTrackMapper.insert(atm);
    }


}
