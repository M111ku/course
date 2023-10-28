package com.edu.mapper;

import com.edu.pojo.Process;

public interface ProcessMapper {

    /**
     * 创建默认审批流
     * @param process
     */
    void addDefault(Process process);

    /**
     * 查询对应课程的审批流
     * @param cid
     * @return
     */
    Process selectByCid(String cid);

    /**
     * 更新审批流
     * @param process
     */
    void updateProcess(Process process);

    Process selectBycid(String cid);
}
