package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

public interface ProjectService {

	Map<String, Object> selectById(Long paincbuyProjectId);

	List<Map<String, Object>> selectCanPreProject();

	String searchProjects(long userId);

	Map<String, Object> selectCanPreProjectOne();

	int updateProject(Long paincbuyProjectId, Short num, int type);

}
