<template>
  <div class="index-content">
    <div class="index-content-header">
      <span class="index-content-title">奖牌总榜</span>

    </div>
    <div class="divider-box">
      <div class="divider-blue"></div>
      <el-divider class="divider"/>
    </div>
    <div class="table-content">
      <el-table :data="rankData" style="width: 100%" :header-cell-style="{background:'#00c7ff',fontWeight:'bold',color:'white'}">
        <el-table-column prop="rank" label="排名"  />
        <el-table-column prop="name" label="国家地区" />
        <el-table-column prop="gold" label="金牌" />
        <el-table-column prop="silver" label="银牌"  />
        <el-table-column prop="bronze" label="铜牌" />
        <el-table-column prop="value" label="总数"  />
      </el-table>
    </div>
  </div>
</template>

<script>


export default {
  data(){
    return{
      rankData:[{},{},{},{},{},{},{},{},{},{}],
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

    })
  }
}
</script>

<style scoped>
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
</style>