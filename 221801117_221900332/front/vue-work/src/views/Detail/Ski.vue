<template>
  <div class="back">
    <img class="backImg" :src="backImg" alt="">
    <div class="competition-title">冰壶 混双循环赛第13轮</div>
    <div class="fight-country">
      <span class="country-flag-one">
        <img :src="oneFlag" alt="服务器异常">
      </span>
      <span class="country-flag-two">
        <img :src="twoFlag" alt="服务器异常">
      </span>
      <span class="country-flag-two">
        <img :src="threeFlag" alt="服务器异常">
      </span>
      <span class="country-flag-two">
        <img :src="fourFlag" alt="服务器异常">
      </span>
    </div>
    <div class="index-content">
      <div class="index-content-header">
        <span class="index-content-title">实时数据</span>
      </div>
      <div class="divider-box">
        <div class="divider-blue"></div>
        <el-divider class="divider"/>
      </div>
      <div class="table-content">
        <el-table :data="tableData" >
          <el-table-column prop="rank" label="排名" />
          <el-table-column prop="order" label="出场顺序" />
          <el-table-column prop="number" label="背心号码"  />
          <el-table-column prop="country" label="国家/地区"  />
          <el-table-column prop="name" label="姓名/代表队"  />
          <el-table-column prop="score" label="成绩"  />
        </el-table>
      </div>
    </div>

  </div>

</template>

<script>
import ChinaFlag from '@/assets/中国国旗.png'
import jiekeFlag from '@/assets/捷克国旗.png'
import GermanFlag from '@/assets/德国.png'
import FranchFlag from '@/assets/法国.png'
import BackImg from "@/assets/erji_top_bg.jpg";
export default {
  name: "IcePot",
  data(){
    return{
      tableData:[{data:12},{data:12}],
      oneFlag:ChinaFlag,
      twoFlag:jiekeFlag,
      threeFlag:GermanFlag,
      fourFlag:FranchFlag,
      backImg:BackImg,
      name:this.$route.query.name,
      result:'',
    }
  },
  mounted() {
    this.$axios({
      method:'get',
      url:'/api1/getSki',
      params:{
        documentcode:this.$route.query.documentcode
      }
    }).then(res=>{
      console.log(res)
      let data = res.data.detail.split(",");

      for(let i =0;i<data.length;i+=6){
        let element = {};
        element.rank = data[i];
        element.order = data[i+1];
        element.number = data[i+2];
        element.country = data[i+3];
        element.name = data[i+4];
        element.score = data[i+5];
        this.tableData.push(element);
        console.log(element)
      }

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
  margin-left:40px;
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