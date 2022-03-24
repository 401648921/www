<template>
  <div>
  <div class="echarts">
    <div :style="{height:'800px',width:'100%'}" ref="myEchart"></div>
  </div>
  <div id="medal-card">
    <el-card class="box-card MedalCard">
      <div class="countryName" id="countryname"></div>
      <div class="medalRank" id="rank" ></div>
      <div class="medal-content">
        <span class="medal-title">金牌:</span>
        <span class="medal-num" id="gold"></span>
        <span class="medal-icon gold-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
      <div class="medal-content">
        <span class="medal-title">银牌:</span>
        <span class="medal-num" id="silver" ></span>
        <span class="medal-icon silver-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
      <div class="medal-content">
        <span class="medal-title">铜牌:</span>
        <span class="medal-num" id="copper"></span>
        <span class="medal-icon copper-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
    </el-card>
  </div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import '../../../node_modules/echarts/map/js/world.js'
import CountryMedalCard from "@/components/Common/CountryMedalCard";
export default {
  name: "World",
  components:{
    CountryMedalCard
  },
  methods:{
    go(parm){
      this.show = !this.show;
      console.log(parm)
    }
  },
  data(){
    return{
      show:false,
      echarts:null,
      www:'11',
      option:{
        title: {
          sublink: 'http://esa.un.org/wpp/Excel-Data/population.htm',
          left: 'center',
          top: 'top'
        },
        www:111,
        tooltip: {
          triggerOn: 'click',
          trigger: 'item',
          formatter: function (params) {
            let show = "hidden";
            if(document.getElementById("medal-card").style.visibility == "hidden"){
              show = "visible"
            }else{
              show = "hidden";
            }
            document.getElementById("medal-card").style.visibility=show;
            let data = params.data;
            document.getElementById("countryname").innerText = data.name;
            document.getElementById("rank").innerText="奖牌榜第"+data.rank+"名";
            document.getElementById("gold").innerText=data.gold;
            document.getElementById("silver").innerText=data.silver;
            document.getElementById("copper").innerText=data.bronze;

          }
        },
        visualMap: {
          min: 0,
          max: 37,
          text:['多','少'],
          realtime: false,
          calculable: true,
          color: ['#F87326','#F5DD7C']
        },
        series: [
          {
            name: 'World Population (2010)',
            type: 'map',
            mapType: 'world',
            roam: true,
            itemStyle:{
              emphasis:{label:{show:true}}
            },
            data: [
              {
                "bronze": "13",
                "rank": "1",
                "value": "37",
                "silver": "8",
                "name": "Norway",
                "gold": "16",
                "valueryid": "NOR"
              },
              {
                "bronze": "5",
                "rank": "2",
                "value": "27",
                "silver": "10",
                "name": "Germany",
                "gold": "12",
                "valueryid": "GER"
              },
              {
                "bronze": "2",
                "rank": "3",
                "value": "15",
                "silver": "4",
                "name": "China",
                "gold": "9",
                "valueryid": "CHN"
              },
              {
                "bronze": "7",
                "rank": "4",
                "value": "25",
                "silver": "10",
                "name": "America",
                "gold": "8",
                "valueryid": "USA"
              },
              {
                "bronze": "5",
                "rank": "5",
                "value": "18",
                "silver": "5",
                "name": "Sweden",
                "gold": "8",
                "valueryid": "SWE"
              },
              {
                "bronze": "4",
                "rank": "6",
                "value": "17",
                "silver": "5",
                "name": "Netherlands",
                "gold": "8",
                "valueryid": "NED"
              },
              {
                "bronze": "4",
                "rank": "7",
                "value": "18",
                "silver": "7",
                "name": "Austria",
                "gold": "7",
                "valueryid": "AUT"
              },
              {
                "bronze": "5",
                "rank": "8",
                "value": "14",
                "silver": "2",
                "name": "Switzerland",
                "gold": "7",
                "valueryid": "SUI"
              },
              {
                "bronze": "14",
                "rank": "9",
                "value": "32",
                "silver": "12",
                "name": "Russia",
                "gold": "6",
                "valueryid": "ROC"
              },
              {
                "bronze": "2",
                "rank": "10",
                "value": "14",
                "silver": "7",
                "name": "France",
                "gold": "5",
                "valueryid": "FRA"
              },
              {
                "bronze": "14",
                "rank": "11",
                "value": "26",
                "silver": "8",
                "name": "Canada",
                "gold": "4",
                "valueryid": "CAN"
              },
              {
                "bronze": "9",
                "rank": "12",
                "value": "18",
                "silver": "6",
                "name": "Japan",
                "gold": "3",
                "valueryid": "JPN"
              },
              {
                "bronze": "8",
                "rank": "13",
                "value": "17",
                "silver": "7",
                "name": "Italy",
                "gold": "2",
                "valueryid": "ITA"
              },
              {
                "bronze": "2",
                "rank": "14",
                "value": "9",
                "silver": "5",
                "name": "Korea",
                "gold": "2",
                "valueryid": "KOR"
              },
              {
                "bronze": "2",
                "rank": "15",
                "value": "7",
                "silver": "3",
                "name": "Slovenia",
                "gold": "2",
                "valueryid": "SLO"
              },
              {
                "bronze": "4",
                "rank": "16",
                "value": "8",
                "silver": "2",
                "name": "Finland",
                "gold": "2",
                "valueryid": "FIN"
              },
              {
                "bronze": "0",
                "rank": "17",
                "value": "3",
                "silver": "1",
                "name": "New Zealand",
                "gold": "2",
                "valueryid": "NZL"
              },
              {
                "bronze": "1",
                "rank": "18",
                "value": "4",
                "silver": "2",
                "name": "Australia",
                "gold": "1",
                "valueryid": "AUS"
              },
              {
                "bronze": "0",
                "rank": "19",
                "value": "2",
                "silver": "1",
                "name": "Britain",
                "gold": "1",
                "valueryid": "GBR"
              },
              {
                "bronze": "2",
                "rank": "20",
                "value": "3",
                "silver": "0",
                "name": "Hungary",
                "gold": "1",
                "valueryid": "HUN"
              },
              {
                "bronze": "1",
                "rank": "21",
                "value": "2",
                "silver": "0",
                "name": "Czech Republic",
                "gold": "1",
                "valueryid": "CZE"
              },
              {
                "bronze": "1",
                "rank": "21",
                "value": "2",
                "silver": "0",
                "name": "Slovakia",
                "gold": "1",
                "valueryid": "SVK"
              },
              {
                "bronze": "1",
                "rank": "21",
                "value": "2",
                "silver": "0",
                "name": "Belgium",
                "gold": "1",
                "valueryid": "BEL"
              },
              {
                "bronze": "0",
                "rank": "24",
                "value": "2",
                "silver": "2",
                "name": "Belarus",
                "gold": "0",
                "valueryid": "BLR"
              },
              {
                "bronze": "0",
                "rank": "25",
                "value": "1",
                "silver": "1",
                "name": "Spain",
                "gold": "0",
                "valueryid": "ESP"
              },
              {
                "bronze": "0",
                "rank": "25",
                "value": "1",
                "silver": "1",
                "name": "Ukraine",
                "gold": "0",
                "valueryid": "UKR"
              },
              {
                "bronze": "1",
                "rank": "27",
                "value": "1",
                "silver": "0",
                "name": "Poland",
                "gold": "0",
                "valueryid": "POL"
              },
              {
                "bronze": "1",
                "rank": "27",
                "value": "1",
                "silver": "0",
                "name": "Latvia",
                "gold": "0",
                "valueryid": "LAT"
              },
              {
                "bronze": "1",
                "rank": "27",
                "value": "1",
                "silver": "0",
                "name": "Estonia",
                "gold": "0",
                "valueryid": "EST"
              }
            ]
          }
        ]
      }
    }
  },
  mounted() {
    this.echart = echarts.init(this.$refs.myEchart);
    this.echart.setOption(this.option);

  }
}
</script>

<style scoped>
.medal-icon{
  display: inline-block;
  width: 20px;
  background: white;
}
.MedalCard{
  width:200px;
}
.countryName{
  text-indent: 1em;
  margin-top:0px;
  text-align: left;
  font-size: 16px;
}
.medalRank{
  text-align: left;
  color: #5e5e5e;
  text-indent: 1em;
  margin-top:5px;
  font-size: 13px;
}
.medal-content{
  text-align: left;
}
.medal-title{
  margin-left:0.95em;
  font-size: 15px;
}
.medal-num{
  margin-left:20px;
}
.medal-icon{
  position: relative;
  top:5px;
  left:5px;
}
.gold-icon{
  color: gold;
}
.silver-icon{
  color: silver;
}
.copper-icon{
  color: #5e572f;
}
#medal-card{
  z-index: 10;
  position: absolute;
  right:100px;
  bottom: 200px;
  visibility: hidden;
}
.echarts{
  background: #f5f5f5;
}
</style>