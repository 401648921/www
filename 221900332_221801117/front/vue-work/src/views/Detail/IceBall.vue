<template>
  <div class="back">
    <img class="backImg" :src="backImg" alt="">
    <div class="competition-title" v-text="name"></div>
    <div class="fight-country">
    <span class="country-flag-one">
      <img :src="oneFlag" alt="服务器异常">
    </span>
      <span class="mid-content">
      <span class="race-title">VS</span>
      <span class="race-num" v-text="result"></span>
    </span>
      <span class="country-flag-two">
      <img :src="twoFlag" alt="服务器异常">
    </span>
    </div>
    <div class="detail-data-box">
      <div class="team-detail">
        <el-table :data="homeArray" style="width: 100%">
          <el-table-column prop="name" label="姓名" width="280" />
          <el-table-column prop="position" label="位置" width="180" />
        </el-table>
      </div>
      <div class="detail-mid-content">
        <div class="index-content">
          <div class="index-content-header">
            <span class="index-content-title">两队比分</span>
          </div>
          <div class="divider-box">
            <div class="divider-blue"></div>
            <el-divider class="divider"/>
          </div>
          <div class="table-content">
            <el-table :data="dataArray" >
              <el-table-column prop="name" label="国家/地区" width="100"/>
              <el-table-column prop="p1" label="第一节" width="100" />
              <el-table-column prop="p2" label="第二节" width="100" />
              <el-table-column prop="p3" label="第三节" width="100" />
              <el-table-column prop="p4" label="加时" width="100" />
              <el-table-column prop="p5" label="点球" width="100" />
              <el-table-column prop="count" label="总分" width="100" />
            </el-table>
          </div>
        </div>
        <div class="index-content">
          <div class="index-content-header">
            <span class="index-content-title">比赛数据</span>
          </div>
          <div class="divider-box">
            <div class="divider-blue"></div>
            <el-divider class="divider"/>
          </div>
          <div  class="table-content">
            <div ref="dataEcharts" class="echarts" style="width: 600px;height:400px;"></div>
          </div>
        </div>
      </div>
      <div class="team-detail">
        <el-table :data="awayArray" style="width: 100%">
          <el-table-column prop="name" label="姓名" width="280" />
          <el-table-column prop="position" label="位置" width="180" />
        </el-table>
      </div>
    </div>
  </div>

</template>

<script>
import  BackImg from '@/assets/erji_top_bg.jpg'
import * as echarts from 'echarts'
import ChinaFlag from '@/assets/中国国旗.png'
import jiekeFlag from '@/assets/捷克国旗.png'
export default {
  name: "IceBall",
  data(){
    return{
      oneFlag:ChinaFlag,
      twoFlag:jiekeFlag,
      backImg:BackImg,
      name:this.$route.query.name,
      echarts:'',
      result:'',
      homeArray:[],
      awayArray:[],
      dataArray:[],
      option: {
        title: {
          text: ''
        },
        tooltip: {},
        legend: {
          data: ['销量']
        },
        xAxis: {
          data: ['得分','射门', '多打少', '争球','被罚时间', '短手进球']
        },
        yAxis: {},
        series: [
          {
            name: '捷克',
            type: 'bar',
            data: [ 36, 10, 10, 20,20,20]
          },
          {
            name: '中国',
            type: 'bar',
            data: [5, 20, 36, 10,20,20]
          }
        ]
      },
      tableData1:[{data:12},{data:12}],
      tableData:[{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23},{date:12,name:23}]
    }
  },
  mounted() {
    this.$axios({
      method:'get',
      url:'/api1/getIceBall',
      params:{
        documentcode:this.$route.query.documentcode
      }
    }).then(res=>{
      let data = res.data;
      this.result = data.result;
      console.log(res)
      let homeathletes = data.homeathlete.split(",");
      let homepositions = data.homeposition.split(",");
      let awayathletes = data.awayathlete.split(",");
      let awaypositions = data.awayposition.split(",");
      for(let i =0;i<homeathletes.length;i++){
        let element1 = {
          name:homeathletes[i],
          position:homepositions[i]
        };
        let element2 = {
          name:awayathletes[i],
          position:awaypositions[i]
        }
        this.homeArray.push(element1);
        this.awayArray.push(element2);
        console.log(this.homeArray)
      }
      let homeCount = 0;
      let awayCount = 0;
      let homedetails = data.homeecharts.split(",");
      let awaydetails = data.awayecharts.split(",");
      let dataElement1 = {};
      let dataElement2 = {};
      dataElement1['name'] =this.$route.query.homename;
      dataElement2['name'] = this.$route.query.awayname;
      for(let i =0;i<homedetails.length;i++){
        dataElement1['p'+(i+1)] = homedetails[i];
        dataElement2['p'+(i+1)] = awaydetails[i];
        homeCount += Number(homedetails[i]);
        awayCount += Number(awaydetails[i]);
      }
      dataElement1['count'] = homeCount;
      dataElement2['count'] = awayCount;
      this.dataArray.push(dataElement1);
      this.dataArray.push(dataElement2);

      let homeechartses = data.homedetail.split(",");
      let awayechartses  = data.awaydetail.split(",");
      this.option.series[0].data = homeechartses;
      this.option.series[1].data = awayechartses;
      this.echart = echarts.init(this.$refs.dataEcharts);
      this.echart.setOption(this.option);

    })

  }
}
</script>

<style scoped>
.back{
  position: relative;
  width:100%;
  overflow: hidden;
}
.backImg{
  position: absolute;
  left:0px;
  top:0px;
  z-index: -10;
}
.index-content{
  margin-top:60px;
  width:90%;
  position: relative;
  margin-left:5%;
}
.index-content-title{
  font-size: 20px;
  float: left;
  text-indent: 1em;
  line-height: 20px;
}
.divider{
}
.divider-blue{
  height: 20px;
  border-bottom: #00c7ff 3px solid;
  width:150px;
  position: relative;
  top:25px;
}
.detail-data-box{
  display: flex;
  justify-content: center;
  margin-top:30px;
}
.detail-mid-content{
  width:850px;
  margin-left:25px;
  margin-right: 25px;
  background: white;
}
.team-detail{
  display: inline-block;
  width:400px;
  border:#5e5e5e 1px solid;
}
.competition-title{
  height:150px;
  font-size: 40px;
  line-height: 130px;
  color: #00c7ff;
}
.country-flag-one{
  background: #c2c7cc;
  width:300px;
  display: inline-block;
  height:300px;
  justify-content: center;
}
.country-flag-two{
  background: #c2c7cc;
  width:300px;
  display: inline-block;
  height:300px;
  justify-content: center;
}
.country-flag-two img{
  width:300px;
}
.mid-content{

}
.table-content{
  position: relative;
  width:700px;
}
.country-flag-one img{
  width:300px;
}
.fight-country{
  flex-direction:row ;
  display: flex;
  justify-content: center;
}
.mid-content{
  width:600px;
}
.race-title{
  font-size: 150px;
  display: block;
  font-weight: bolder;
  margin-top:30px;
  font-style: italic;
}
.race-num{
  font-size: 80px;
  color: #00c7ff;
  display: block;
  margin-top:50px;
}
</style>