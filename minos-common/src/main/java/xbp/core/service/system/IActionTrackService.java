package xbp.core.service.system;

import org.springframework.stereotype.Service;

import xbp.core.model.system.ActionTrackModel;

@Service
public interface IActionTrackService {

    /**
     * @Description: 来访信息表插入
     * @author zhangjs
     * @param ip
     * @param atm
     */
    public void saveGuestInfro(String ip, ActionTrackModel atm) throws Exception;

}
