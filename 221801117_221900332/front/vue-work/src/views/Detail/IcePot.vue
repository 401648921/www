<template>
  <div class="back">
    <img class="backImg" :src="backImg" alt="">
    <div class="competition-title">冰壶 混双循环赛第13轮</div>
    <div class="fight-country">
      <span class="country-flag-one">
        <img :src="oneFlag" alt="服务器异常">
      </span>
      <span class="mid-content">
        <span class="race-title">VS</span>
        <span class="race-num">8 : 6</span>
      </span>
      <span class="country-flag-two">
      <img :src="twoFlag" alt="服务器异常">
    </span>
    </div>
    <div class="index-content">
      <div class="index-content-header">
        <span class="index-content-title">分局结果</span>
      </div>
      <div class="divider-box">
        <div class="divider-blue"></div>
        <el-divider class="divider"/>
      </div>
      <div class="table-content">
        <el-table :data="tableData1" >
          <el-table-column prop="data" label="国家/地区" />
          <el-table-column prop="name" label="第1局" />
          <el-table-column prop="data" label="第2局"  />
          <el-table-column prop="name" label="第3局"  />
          <el-table-column prop="name" label="第4局"  />
          <el-table-column prop="data" label="第5局"  />
          <el-table-column prop="name" label="第6局"  />
          <el-table-column prop="name" label="第7局"  />
          <el-table-column prop="data" label="第8局"  />
          <el-table-column prop="name" label="第9局"  />
          <el-table-column prop="name" label="第10局"  />
          <el-table-column prop="data" label="总分"  />
        </el-table>
      </div>
    </div>
    <div class="index-content">
      <div class="index-content-header">
        <span class="index-content-title">参赛人员</span>
      </div>
      <div class="divider-box">
        <div class="divider-blue"></div>
        <el-divider class="divider"/>
      </div>
      <div class="table-content">
        <el-table :data="tableData1" >
          <el-table-column prop="data" label="国家/地区" />
          <el-table-column prop="name" label="男运动员" />
          <el-table-column prop="data" label="女运动员"  />
        </el-table>
      </div>
    </div>
  </div>

</template>

<script>
import ChinaFlag from '@/assets/中国国旗.png'
import jiekeFlag from '@/assets/捷克国旗.png'
import BackImg from "@/assets/erji_top_bg.jpg";
export default {
  name: "IcePot",
  data(){
    return{
      tableData1:[{data:12},{data:12}],
      oneFlag:ChinaFlag,
      twoFlag:jiekeFlag,
      backImg:BackImg,
    }
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
  width:70%;
  position: relative;
  margin-left:15%;
  margin-bottom: 100px;
}
@media screen and (max-width: 1500px){
  .index-content{
    width:1050px !important;
    margin-left:225px !important;
  }
}
.index-content-title{
  font-size: 20px;
  float: left;
  text-indent: 1em;
  color: black;
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
  width:100%;
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