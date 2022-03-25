<template>
  <div class="img-running-box">
    <el-carousel height="450px">
      <el-carousel-item v-for="item in pics" :key="item">
        <img :src="item" alt="服务器故障">
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="index-content">
    <div class="index-content-header">
      <span class="index-content-title">每日赛程</span>
      <span class="index-content-right">
        <span class="index-content-push" @click="go('/home/mainPage/schedule')">更多赛程</span>
        <svg class="index-content-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M338.752 104.704a64 64 0 0 0 0 90.496l316.8 316.8-316.8 316.8a64 64 0 0 0 90.496 90.496l362.048-362.048a64 64 0 0 0 0-90.496L429.248 104.704a64 64 0 0 0-90.496 0z"></path></svg>
      </span>
    </div>
    <div class="divider-box">
      <div class="divider-blue"></div>
      <el-divider class="divider"/>
    </div>
    <div class="table-content">
      <el-table :data="scheduleData" style="width: 100%" :header-cell-style="{background:'#00c7ff',fontWeight:'bold',color:'white'}">
        <el-table-column prop="time" label="时间"  />
        <el-table-column prop="sport" label="大项"  />
        <el-table-column prop="name" label="比赛" />
        <el-table-column prop="venue" label="场馆"  />
        <el-table-column prop="address" label="操作" >
          <template #default="scope">
            <span @click="push(scope.$index)">成绩公报</span>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
  <div class="index-content">
    <div class="index-content-header">
      <span class="index-content-title">奖牌总榜</span>
      <span class="index-content-right">
        <span class="index-content-push" @click="go('/home/mainPage/rank')">完整榜单</span>
        <svg class="index-content-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M338.752 104.704a64 64 0 0 0 0 90.496l316.8 316.8-316.8 316.8a64 64 0 0 0 90.496 90.496l362.048-362.048a64 64 0 0 0 0-90.496L429.248 104.704a64 64 0 0 0-90.496 0z"></path></svg>
      </span>
    </div>
    <div class="divider-box">
      <div class="divider-blue"></div>
      <el-divider class="divider"/>
    </div>
    <div class="table-content">
      <el-table :data="rankData" style="width: 100%">
        <el-table-column prop="rank" label="排名"  />
        <el-table-column prop="name" label="国家地区" />
        <el-table-column prop="gold" label="金牌" />
        <el-table-column prop="silver" label="银牌"  />
        <el-table-column prop="bronze" label="铜牌" />
        <el-table-column prop="value" label="总数"  />
      </el-table>
    </div>
  </div>
  <div class="index-content">
    <div class="index-content-header">
      <span class="index-content-title">每日赛程</span>

    </div>
    <div class="divider-box">
      <div class="divider-blue"></div>
      <el-divider class="divider"/>
    </div>
    <div class="text-content">
      冬季奥林匹克运动会（Olympic Winter Games）简称为冬季奥运会、冬奥会。主要由全世界地区举行，是世界规模最大的冬季综合性运动会，每四年举办一届，1994年起与夏季奥林匹克运动会相间举行。参与国主要分布在世界各地，包括欧洲、非洲、美洲、亚洲、大洋洲。由国际奥林匹克委员会（International Olympic Committee）主办。按实际举行次数计算届数。

      1986年，国际奥委会全会决定把冬季奥运会和夏季奥运会从1994年起分开，每两年间隔举行，1992年冬季奥运会是最后一届与夏季奥运会同年举行的冬奥会。自1924年开始第1届，截至2018年共举办了23届，每四年一届。

      第24届冬季奥林匹克运动会于2022年2月4日至2月20日在中国 [8]  北京和张家口举行。2022年1月14日，联合国邮政管理局宣布，为庆祝2022年北京冬奥会的召开，联合国发行主题为“体育促进和平”的邮票。这是联合国首次为冬奥会发行邮票。
    </div>
  </div>

</template>

<script>
import pic1 from '@/assets/carousel1.jpg'
import pic2 from '@/assets/carousel2.jpg'
export default {
  name: "Index",
  data(){
    return{
      pics:[pic1,pic2],
      rankData:[{},{},{},{},{},{},{},{},{},{}],
      scheduleData:[]
    }
  },
  methods:{
    go(path){
      this.$router.push(path);
    },
    push(index){
      let path = "";
      if(this.scheduleData[index].sport=='冰壶'){
        path = '/home/detail/icePot'
      }else if(this.scheduleData[index].sport=='冰球'){
        path = '/home/detail/iceBall'
      }else if(this.scheduleData[index].sport=='自由式滑雪'){
        path = '/home/detail/ski'
      }else{
        return;
      }
      let name = this.scheduleData[index].name;
      let documentcode = this.scheduleData[index].documentcode;
      this.$router.push({
        path:path,
        query:{
          name:name,
          documentcode:documentcode,
          homename:this.scheduleData[index].homename,
          awayname:this.scheduleData[index].awayname,
        }
      })
    }
  },
  mounted() {
    this.$axios({
      method:'get',
      url:'/api1/getTotal'
    }).then(res=>{
      this.rankData = res.data;
      this.rankData = this.rankData.sort(function (a,b){
        return a.rank-b.rank;
      })
      this.rankData = this.rankData.slice(0,5)
      //console.log(this.rankData)

    })
    this.$axios({
      method:'get',
      url:'/api1/getSchedule',
      params:{
        time:"2022-02-02"
      }
    }).then(res=>{
      this.scheduleData = res.data.slice(0,6);
      console.log(res);
    })
  }
}
</script>

<style scoped>
.img-running-box{
  background: #2061fb;
  height:455px;
}
@media screen and (max-width:1500px)  {
  .index-content{
    width: 1350px !important;
    margin-left:225px !important;
  }
}
.index-content{
  margin-top:120px;
  width:70%;
  position: relative;
  margin-left:15%;

}
.index-content-icon{
  display: inline-block;
  width:20px;
  position: relative;
  top:5px;
}
.index-content-title{
  font-size: 20px;
  float: left;
  text-indent: 1em;
  line-height: 20px;
}
.index-content-push{
  line-height: 20px;
}
.index-content-right{
  float: right;
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
.text-content{
  text-indent: 2em;
  text-align: left;
  width:93%;
  margin-left:2%;
  margin-bottom: 100px;
  font-style: italic
}
</style>