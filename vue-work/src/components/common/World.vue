<template>
  <div>
  <div class="echarts">
    <div @click="go" :style="{height:'400px',width:'1000px'}" ref="myEchart"></div>
  </div>
  <div id="medal-card" v-show="show">
    <CountryMedalCard></CountryMedalCard>
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
    }
  },
  data(){
    return{
      show:false,
      echarts:null,
      option:{
        title: {
          sublink: 'http://esa.un.org/wpp/Excel-Data/population.htm',
          left: 'center',
          top: 'top'
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
#medal-card{
  z-index: 10;
  position: absolute;
  left:900px;
  top:200px;
}
</style>