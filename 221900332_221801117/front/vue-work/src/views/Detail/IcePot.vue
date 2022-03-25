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
    <div class="index-content">
      <div class="index-content-header">
        <span class="index-content-title">分局结果</span>
      </div>
      <div class="divider-box">
        <div class="divider-blue"></div>
        <el-divider class="divider"/>
      </div>
      <div class="table-content">
        <el-table :data="array" >
          <el-table-column prop="name" label="国家/地区" />
          <el-table-column prop="p1" label="第1局" />
          <el-table-column prop="p2" label="第2局"  />
          <el-table-column prop="p3" label="第3局"  />
          <el-table-column prop="p4" label="第4局"  />
          <el-table-column prop="p5" label="第5局"  />
          <el-table-column prop="p6" label="第6局"  />
          <el-table-column prop="p7" label="第7局"  />
          <el-table-column prop="p8" label="第8局"  />
          <el-table-column prop="p9" label="第9局"  />
          <el-table-column prop="p10" label="第10局"  />
          <el-table-column prop="count" label="总分"  />
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
        <el-table :data="athlete" >
          <el-table-column prop="name" label="国家/地区" />
          <el-table-column prop="man" label="男运动员" />
          <el-table-column prop="woman" label="女运动员"  />
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
      data:{},
      result:'',
      period1:[],
      period2:[],
      athlete1:[],
      athlete2:[],
      athlete:[],
      name:'',
      array:[]
    }
  },
  methods:{

  },
  mounted() {
    this.$axios({
      method:'get',
      url:'/api1/getIcePot',
      params:{
        documentcode:this.$route.query.documentcode
      }
    }).then(res=>{
      console.log(res)
      this.data = res.data
      this.result = this.data.result;
      //this.athlete1 = [this.data.athletef1,this.data.athletem1];
      //this.athlete2 = [this.data.athletef2,this.data.athletem2];
      this.athlete1 = {
        name:this.$route.query.homename,
        man:this.data.athletef1,
        woman:this.data.athletem1
      }
      this.athlete2 = {
        name:this.$route.query.awayname,
        man:this.data.athletef2,
        woman:this.data.athletem2
      }
      this.athlete = [this.athlete1,this.athlete2]
      this.period1 = this.data.period1.split(',');
      this.period2 = this.data.period2.split(',');
      let element1 = {};
      let element2 =  {};
      element1['name'] = this.$route.query.homename;
      element2['name'] = this.$route.query.awayname;
      //console.log(this.period2)
      let count1 = 0;
      let count2 = 0;
      for(let i =0;i<this.period1.length;i++){
        element1['p'+(i+1)] = this.period1[i];
        count1+= Number(this.period1[i])
      }
      for(let i =0;i<this.period2.length;i++){
        element2['p'+(i+1)] = this.period2[i]
        count2+= Number(this.period2[i])
      }
      element1['count'] = count1;
      element2['count'] = count2;
      this.array = [element1,element2];
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