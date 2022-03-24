<template>
  <div class="from-box">
    <div class="from-item">
      <el-select v-model="time" placeholder="比赛场馆">
        <el-option
            v-for="item in times"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div class="from-item">
      <el-select v-model="venue" placeholder="比赛场馆">
        <el-option
            v-for="item in places"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div class="from-item">
      <el-select v-model="sport" placeholder="比赛项目">
        <el-option
            v-for="item in sports"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div class="from-item">
      <el-button type="primary" @click="search">查询</el-button>
    </div>
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
</template>

<script>
export default {
  name: "Schedule",
  mounted() {
    this.search();
  },

  data(){
    return{
      scheduleData:[],
      time:"2022-02-02",
      venue:'',
      sport:'',
      sports:[
        {
          value:'',
          label:'空'
        },
        {
          value:'北欧两项',
          label:'北欧两项'
        },
        {
          value:'冰壶',
          label:'冰壶'
        },
        {
          value:'冰球',
          label:'冰球'
        },
        {
          value:'单板滑雪',
          label:'单板滑雪'
        },
        {
          value:'冬季两项',
          label:'冬季两项'
        },
        {
          value:'短道速滑',
          label:'短道速滑'
        },
        {
          value:'钢架雪车',
          label:'钢架雪车'
        },
        {
          value:'高山滑雪',
          label:'高山滑雪'
        },
        {
          value:'花样滑冰',
          label:'花样滑冰'
        },
        {
          value:'速度滑雪',
          label:'速度滑雪'
        },
        {
          value:'跳台滑雪',
          label:'跳台滑雪'
        },
        {
          value:'雪车',
          label:'雪车'
        },
        {
          value:'雪橇',
          label:'雪橇'
        },
        {
          value:'越野滑雪',
          label:'越野滑雪'
        },
        {
          value:'自由式滑雪',
          label:'自由式滑雪'
        },],
     places:[
       {
         value:'',
         label:'空'
       },
        {
          value:'国家体育馆',
          label:'国家体育馆'
        },
        {
          value:'首钢滑雪大跳台',
          label:'首钢滑雪大跳台'
        },
        {
          value:'首都体育馆',
          label:'首都体育馆'
        },
        {
          value:'国家游泳中心',
          label:'国家游泳中心'
        },
        {
          value:'国家体育馆',
          label:'国家体育馆'
        },
        {
          value:'国家速滑馆',
          label:'国家速滑馆'
        },
        {
          value:'五棵松体育中心',
          label:'五棵松体育中心'
        },
        {
          value:'国家高山滑雪中心',
          label:'国家高山滑雪中心'
        },
        {
          value:'国家学车雪橇中心',
          label:'国家学车雪橇中心'
        },
        {
          value:'国家冬季两项中心',
          label:'国家冬季两项中心'
        },
        {
          value:'国家越野滑雪中心',
          label:'国家越野滑雪中心'
        },
        {
          value:'国家跳台滑雪中心',
          label:'国家跳台滑雪中心'
        },
        {
          value:'云顶滑雪公园',
          label:'云顶滑雪公园'
        },
        ],
      times:[
        {
          value:'',
          label:'空'
        },
        {
          value:'2022-02-02',
          label:'2022-02-02'
        },
        {
          value:'2022-02-03',
          label:'2022-02-03'
        },
        {
          value:'2022-02-04',
          label:'2022-02-04'
        },
        {
          value:'2022-02-05',
          label:'2022-02-05'
        },
        {
          value:'2022-02-06',
          label:'2022-02-06'
        },
        {
          value:'2022-02-07',
          label:'2022-02-07'
        },
        {
          value:'2022-02-08',
          label:'2022-02-08'
        },
        {
          value:'2022-02-09',
          label:'2022-02-09'
        },
        {
          value:'2022-02-10',
          label:'2022-02-10'
        },
        {
          value:'2022-02-11',
          label:'2022-02-11'
        },
        {
          value:'2022-02-12',
          label:'2022-02-12'
        },
        {
          value:'2022-02-13',
          label:'2022-02-13'
        },
        {
          value:'2022-02-14',
          label:'2022-02-14'
        },
        {
          value:'2022-02-15',
          label:'2022-02-15'
        },
        {
          value:'2022-02-16',
          label:'2022-02-16'
        },
        {
          value:'2022-02-17',
          label:'2022-02-17'
        },
        {
          value:'2022-02-18',
          label:'2022-02-18'
        },
        {
          value:'2022-02-19',
          label:'2022-02-19'
        },
        {
          value:'2022-02-20',
          label:'2022-02-20'
        },

      ]
    }
  },
  methods:{
    search(){
      this.$axios({
        method:'get',
        url:'/api1/getSchedule',
        params:{
          time:this.time,
          venue:this.venue,
          sport:this.sport
        }
      }).then(res=>{
        this.scheduleData = res.data;
        //console.log(res);
      })
    },
    push(index){
      let path = "";
      if(this.scheduleData[index].sport=='冰壶'){
        path = '/home/detail/icePot'
      }else if(this.scheduleData[index].sport=='冰球'){
        path = '/home/detail/iceBall'
      }else if(this.scheduleData[index].sport=='冰球'){
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
  }
}
</script>

<style scoped>
@media screen and (max-width:1500px)  {
  .from-box{
    width: 1200px !important;
    margin-left:150px !important;
  }
  .table-content{
    margin-left:255px !important;
  }
}
.table-content{
  margin-top:20px;
  height:40px;
  width:56%;
  position: relative;
  padding:0px;
  margin-left:17%;
  display: flex;
  min-width: 1080px;
}
.from-box{
  margin-top:20px;
  height:40px;
  width:80%;
  position: relative;
  padding:0px;
  margin-left:10%;
  display: flex;
}
.from-item{
  float: left;
  margin-left:120px;
}
</style>