<template>
  <div class="index-content">
    <div class="index-content-header">
      <span class="index-content-title">奖牌总榜</span>
      <span class="index-content-right">
        <span class="index-content-push">完整榜单</span>
        <svg class="index-content-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M338.752 104.704a64 64 0 0 0 0 90.496l316.8 316.8-316.8 316.8a64 64 0 0 0 90.496 90.496l362.048-362.048a64 64 0 0 0 0-90.496L429.248 104.704a64 64 0 0 0-90.496 0z"></path></svg>
      </span>
    </div>
    <div class="divider-box">
      <div class="divider-blue"></div>
      <el-divider class="divider"/>
    </div>
    <div class="table-content">
      <el-table :data="tableData" style="width: 100%" :header-cell-style="{background:'#00c7ff',fontWeight:'bold',color:'white'}">
        <el-table-column prop="date" label="时间" width="200" />
        <el-table-column prop="name" label="大项" width="300" />
        <el-table-column prop="address" label="比赛" width="480"/>
        <el-table-column prop="name" label="场馆" width="200" />
        <el-table-column prop="address" label="数据" >
          <template #default>
            <span>成绩公报</span>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>


export default {
  data(){
    return{
      tableData:[{},{},{},{},{},{},{},{},{},{}]
    }
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