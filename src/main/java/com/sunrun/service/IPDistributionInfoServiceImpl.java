package com.sunrun.service;


import com.sunrun.entity.DevIpDistributionBean;
import com.sunrun.entity.DevIpSegmentConfigBean;
import com.sunrun.entity.DevIpSegmentDistributionBean;
import com.sunrun.entity.MenuBean;
import com.sunrun.mapper.IPDistributionInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;


@Service("iPDistributionInfoService")
public class IPDistributionInfoServiceImpl implements IPDistributionInfoService {
	private static final Logger logger = LoggerFactory.getLogger(IPDistributionInfoServiceImpl.class);
	@Resource
	private IPDistributionInfoMapper iPDistributionInfoMapper;

	@Override
	public List<DevIpSegmentDistributionBean> findDevIpSegmentDistribution(
			DevIpSegmentDistributionBean devIpSegmentDistributionBean,String exact,String like, String sortBy, String order,
			String limit) {
		 
		return iPDistributionInfoMapper.findDevIpSegmentDistribution(devIpSegmentDistributionBean,  exact, like, sortBy, order, limit);
				}

	@Override
	public Integer countDevIpSegmentDistribution(DevIpSegmentDistributionBean devIpSegmentDistributionBean, String exact,String like) {
		// TODO Auto-generated method stub
		return iPDistributionInfoMapper.countDevIpSegmentDistribution(devIpSegmentDistributionBean,  exact, like);
	}

	@Override
	public List<DevIpSegmentConfigBean> findDevIpSegmentConfigBean(DevIpSegmentConfigBean devIpSegmentConfigBean) {
	 
		return iPDistributionInfoMapper.findDevIpSegmentConfigBean(devIpSegmentConfigBean);
	}

	@Override
	public void saveIpSegmentDistribution(List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList) {
		 
		  iPDistributionInfoMapper.saveIpSegmentDistribution(devIpSegmentDistributionBeanList);
	}

	@Override
	public void saveDevIpDistribution(List<DevIpDistributionBean> devIpDistributionBean) {
		// TODO Auto-generated method stub
		  iPDistributionInfoMapper.saveDevIpDistribution(devIpDistributionBean);
	}

	@Override
	public List<DevIpDistributionBean> findDevIpDistribution(DevIpDistributionBean devIpDistributionBean, String exact,
			String like, String sortBy, String order, String limit) {
 
		return iPDistributionInfoMapper.findDevIpDistribution(devIpDistributionBean, exact, like, sortBy, order, limit);
	}

	@Override
	public List<DevIpSegmentDistributionBean> ipSegment_distribution_historyDataInfo(DevIpSegmentDistributionBean devIpSegmentDistributionBean)  {
		return iPDistributionInfoMapper.find_ipSegment_distribution_historyDataInfo(devIpSegmentDistributionBean);
	}

	@Override
	public List<DevIpDistributionBean> ip_distribution_historyDataInfo(DevIpDistributionBean devIpDistributionBean ) {
		return iPDistributionInfoMapper.find_ip_distribution_historyDataInfo(devIpDistributionBean);
	}

	@Override
	public Integer countDevIpDistribution(DevIpDistributionBean devIpDistributionBean, String exact, String like) {
		// TODO Auto-generated method stub
		return iPDistributionInfoMapper.countDevIpDistribution(devIpDistributionBean, exact, like);
	}

	@Override
	public List<String> findAllocationUser() {
		// TODO Auto-generated method stub
		return iPDistributionInfoMapper.findAllocationUser();
	}

	@Override
	public void editIpSegmentDistribution(List<DevIpSegmentDistributionBean> devIpSegmentDistributionBeanList) {
		  iPDistributionInfoMapper.editIpSegmentDistribution(devIpSegmentDistributionBeanList);
		
	}

	@Override
	public void editIpDistribution(List<DevIpDistributionBean> devIpDistributionBean,DevIpDistributionBean devIpDistributionBean_one) {
		 
		  iPDistributionInfoMapper.editIpDistribution(devIpDistributionBean,  devIpDistributionBean_one);
	}

	@Override
	public void deleteIpSegmentDistribution( DevIpSegmentDistributionBean  devIpSegmentDistributionBean ) {
		iPDistributionInfoMapper.deleteIpSegmentDistribution(devIpSegmentDistributionBean );
	}

	@Override
	public Integer findUserRole(String name, String userId) {
		// TODO Auto-generated method stub
		return iPDistributionInfoMapper.findUserRole(name, userId);
	}

	@Override
	public List<MenuBean> findMenu(MenuBean menuBean) {
		// TODO Auto-generated method stub
		return iPDistributionInfoMapper.findMenu(menuBean);
	}









}
