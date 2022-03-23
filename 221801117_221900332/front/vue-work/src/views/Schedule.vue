<template>
  <div class="from-box">
    <div class="from-item">
      <el-date-picker
          v-model="data"
          type="date"
          placeholder="比赛日期">
      </el-date-picker>
    </div>
    <div class="from-item">
      <el-select v-model="value" placeholder="比赛场馆">
        <el-option
            v-for="item in places"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div class="from-item">
      <el-select v-model="value" placeholder="比赛项目">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
    </div>
    <div class="from-item">
      <el-button type="primary">查询</el-button>
    </div>
  </div>
  <div class="table-content">
    <el-table :data="tableData" style="width: 100%" :header-cell-style="{background:'#00c7ff',fontWeight:'bold',color:'white'}">
      <el-table-column prop="date" label="时间" width="200" />
      <el-table-column prop="name" label="大项" width="200" />
      <el-table-column prop="address" label="比赛" width="280"/>
      <el-table-column prop="name" label="场馆" width="150" />
      <el-table-column prop="address" label="数据" >
        <template #default>
          <span>成绩公报</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "Schedule",
  return:{
    data:''
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