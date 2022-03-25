<template>
  <div class="content-header-content">
    <svg @click="back" class="header-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M685.248 104.704a64 64 0 0 1 0 90.496L368.448 512l316.8 316.8a64 64 0 0 1-90.496 90.496L232.704 557.248a64 64 0 0 1 0-90.496l362.048-362.048a64 64 0 0 1 90.496 0z"></path></svg>
    <span class="header-text">具体赛况</span>
  </div>
  <router-view/>
</template>

<script>
export default {
  name: "DetialIndex",
  methods:{
    back(){
      this.$router.go(-1);//返回上一层
    }
  }
}
</script>

<style scoped>
.content-header-content{
  position: relative;
  background: #c2c7cc;
  height:35px;
}
.header-icon{
  width:20px;
  display: inline-block;
  position: absolute;
  left:20px;
  top:8px;
}
.header-text{
  line-height: 35px;
  font-weight: bolder;
}
</style>