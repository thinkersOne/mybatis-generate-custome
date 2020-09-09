package com.baomidou.mybatisplus.samples.generator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MapDistanceUtil {

        private static final Logger log = LoggerFactory.getLogger(MapDistanceUtil.class);

    //地球平均半径  单位千米
        public static double EARTH_RADIUS = 6371.004;

        //地球平均半径  单位米
        public static double EARTH_RADIUS_M = 6371004;

        public static double rad(double d) {
            return d * Math.PI / 180.0;
        }
        /**
         * 计算两点之间距离
         * @param lat1Str 起始纬度
         * @param lng1Str 起始经度
         * @param lat2Str 目标纬度
         * @param lng2Str 目标经度
         * @return String 多少米
         */
        public static String getLatLngDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str){

            if(StringUtils.isBlank(lat1Str) || StringUtils.isBlank(lng1Str) || StringUtils.isBlank(lat2Str) || StringUtils.isBlank(lng2Str)){
                return null;
            }
            double lat1 = (Math.PI/180)*Double.parseDouble(lat1Str);
            double lat2 = (Math.PI/180)*Double.parseDouble(lat2Str);

            double lon1 = (Math.PI/180)*Double.parseDouble(lng1Str);
            double lon2 = (Math.PI/180)*Double.parseDouble(lng2Str);

            //两点间距离 m，如果想要米的话，结果*1000就可以了
            double dis =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*EARTH_RADIUS;
            dis *= 1000;
            DecimalFormat df = new DecimalFormat("#.00");
            return df.format(dis);
        }

        /**
         * 根据两个位置的经纬度，来计算两地的距离（单位为米）
         * 参数为String类型
         * @param lat1Str 用户经度
         * @param lng1Str 用户纬度
         * @param lat2Str 商家经度
         * @param lng2Str 商家纬度
         * @return 多少米
         */
        public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
            Double lat1 = Double.parseDouble(lat1Str);
            Double lng1 = Double.parseDouble(lng1Str);
            Double lat2 = Double.parseDouble(lat2Str);
            Double lng2 = Double.parseDouble(lng2Str);

            double radLat1 = rad(lat1);
            double radLat2 = rad(lat2);
            double difference = radLat1 - radLat2;
            double mdifference = rad(lng1) - rad(lng2);
            double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                    + Math.cos(radLat1) * Math.cos(radLat2)
                    * Math.pow(Math.sin(mdifference / 2), 2)));
            distance = distance * EARTH_RADIUS_M;
            distance = distance * 10000 / 10000;
            DecimalFormat df = new DecimalFormat("#.00");
            String distanceStr = df.format(distance);
            return distanceStr;
        }

        /**
         * 判断目标车辆是否在站点一定距离范围内
         * @param lat1Str 站点纬度
         * @param lng1Str 站点经度
         * @param lat2Str 目标车辆纬度
         * @param lng2Str 目标车辆经度
         * @Param radius  站点电子围栏半径
         * @return
         */
        public static boolean isAround(String lat1Str, String lng1Str, String lat2Str, String lng2Str,Double radius){
            try {
                String latLngDistance = getLatLngDistance(lat1Str, lng1Str, lat2Str, lng2Str);
                if(StringUtil.isNullOrEmpty(latLngDistance)){
                    return false;
                }
                double v = Double.parseDouble(latLngDistance);
                log.info("lat1Str："+lat1Str + "-----lng1Str:" + lng1Str);
                log.info("lat2Str：" + lat2Str + "-----lng2Str：" + lng2Str);
                log.info("车辆离站点距离："+v + "-----radius：" + radius);
                if(radius >= v){
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;

        }

        /**
         * 获取当前用户一定距离以内的经纬度值
         * 单位米 return minLat
         * 最小经度 minLng
         * 最小纬度 maxLat
         * 最大经度 maxLng
         * 最大纬度 minLat
         */
        public static Map getAround(String latStr, String lngStr, String raidus) {
            Map map = new HashMap();

            Double latitude = Double.parseDouble(latStr);// 传值给经度
            Double longitude = Double.parseDouble(lngStr);// 传值给纬度

            Double degree = (24901 * 1609) / 360.0; // 获取每度
            double raidusMile = Double.parseDouble(raidus);

            Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180))+"").replace("-", ""));
            Double dpmLng = 1 / mpdLng;
            Double radiusLng = dpmLng * raidusMile;
            //获取最小经度
            Double minLat = longitude - radiusLng;
            // 获取最大经度
            Double maxLat = longitude + radiusLng;

            Double dpmLat = 1 / degree;
            Double radiusLat = dpmLat * raidusMile;
            // 获取最小纬度
            Double minLng = latitude - radiusLat;
            // 获取最大纬度
            Double maxLng = latitude + radiusLat;

            map.put("minLat", minLat+"");
            map.put("maxLat", maxLat+"");
            map.put("minLng", minLng+"");
            map.put("maxLng", maxLng+"");

            return map;
        }

        /**
         * 获取一个经纬度一定距离以内的经纬度值
         * @param longitude 经度
         * @Param latitude 纬度
         * @Param dis 距离 单位为千米
         * 单位米 return minLat
         * 最小经度 minLng
         * 最小纬度 maxLat
         * 最大经度 maxLng
         * 最大纬度 minLat
         */
        public static Boolean findNeighPosition(double longitude,double latitude,double dis){
            //先计算查询点的经纬度范围
            double r = EARTH_RADIUS;//地球半径千米
            if(dis == 0){
                dis = 0.5;//0.5千米距离
            }
            double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
            dlng = dlng*180/Math.PI;//角度转为弧度
            double dlat = dis/r;
            dlat = dlat*180/Math.PI;
            double minlat =latitude-dlat;
            double maxlat = latitude+dlat;
            double minlng = longitude -dlng;
            double maxlng = longitude + dlng;

            System.out.println("maxlat:"+maxlat+" "+"minlat:"+minlat+" "+"minlng:"+minlng+" "+"maxlng:"+maxlng);

            if(longitude >= minlng && longitude <= maxlng && latitude >= minlat && latitude <= maxlat){
                return true;
            }
            return false;
        }
        public static void main(String[] args) {
            //测试经纬度：117.11811  36.68484
            //测试经纬度2：117.00999000000002  36.66123
            //System.out.println(getDistance("117.11811","36.68484","117.00999000000002","36.66123"));

            //System.out.println(getAround("117.11811", "36.68484", "13000"));
            //117.01028712333508(Double), 117.22593287666493(Double),
            //36.44829619896034(Double), 36.92138380103966(Double)
            //System.out.println(getDistance("121.2391902931","31.2532198997","121.24368291296103","31.2532198997"));
            //System.out.println(getLatLngDistance("31.2532198997","121.2391902931","31.2532198997","121.24368291296103"));
            //findNeighPosition(121.2391902931,31.2532198997,0.5D);
            // System.out.println(isAround("31.2532198997","121.2391902931","31.2532198997","121.24368291296103",500));
            //System.out.println(str);
            System.out.println(getLatLngDistance("31.307703","121.066978","31.310867854503606","121.06804163123053"));
            System.out.println(getDistance("31.307703","121.066978","31.310867854503606","121.06804163123053"));
            System.out.println(getLatLngDistance("37.693744","112.647851","37.69113430162014","112.6342835938293"));

            //System.out.println(String.format("%.2d", String.valueOf(19887976896D)));
        }

}
