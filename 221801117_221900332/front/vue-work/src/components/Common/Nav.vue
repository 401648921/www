<template>
  <div class="nav">
    <span class="nav-item item-first">首页</span>
    <span class="nav-item">赛程</span>
    <span class="nav-item">奖牌总榜</span>
    <span class="nav-item">奖牌地图</span>
  </div>
  <router-view/>
</template>

<script>
export default {
  name: "Nav"
}
</script>

<style scoped>
.nav{
  background: #c2c7cc;
  height:40px;
}
@media screen and (max-width:1500px){
  .nav{
    width:1500px !important;
  }
}
.item-first{
  margin-left:16%;

}
.nav-item{
  float: left;
  line-height: 40px;
  color: white;
  font-size: 20px;
  margin-right:12%;
  width:120px;
}
.nav-item:hover{
  font-weight: bold;
  background: #00c7ff !important;
}
.active{
  font-weight: bold;
  background: #00c7ff !important;
}
</style>