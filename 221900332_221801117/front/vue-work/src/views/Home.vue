<template>
  <div class="header">
    <span class="header-title">2022北京冬奥会</span>
    <div class="icon-content">
      <span class="icon-box">
        <svg class="header-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 512a192 192 0 1 0 0-384 192 192 0 0 0 0 384zm0 64a256 256 0 1 1 0-512 256 256 0 0 1 0 512zm320 320v-96a96 96 0 0 0-96-96H288a96 96 0 0 0-96 96v96a32 32 0 1 1-64 0v-96a160 160 0 0 1 160-160h448a160 160 0 0 1 160 160v96a32 32 0 1 1-64 0z"></path></svg>
        <span class="icon-box-text">人员</span>
      </span>
      <span class="icon-box">
        <svg class="header-icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="m759.936 805.248-90.944-91.008A254.912 254.912 0 0 1 512 768a254.912 254.912 0 0 1-156.992-53.76l-90.944 91.008A382.464 382.464 0 0 0 512 896c94.528 0 181.12-34.176 247.936-90.752zm45.312-45.312A382.464 382.464 0 0 0 896 512c0-94.528-34.176-181.12-90.752-247.936l-91.008 90.944C747.904 398.4 768 452.864 768 512c0 59.136-20.096 113.6-53.76 156.992l91.008 90.944zm-45.312-541.184A382.464 382.464 0 0 0 512 128c-94.528 0-181.12 34.176-247.936 90.752l90.944 91.008A254.912 254.912 0 0 1 512 256c59.136 0 113.6 20.096 156.992 53.76l90.944-91.008zm-541.184 45.312A382.464 382.464 0 0 0 128 512c0 94.528 34.176 181.12 90.752 247.936l91.008-90.944A254.912 254.912 0 0 1 256 512c0-59.136 20.096-113.6 53.76-156.992l-91.008-90.944zm417.28 394.496a194.56 194.56 0 0 0 22.528-22.528C686.912 602.56 704 559.232 704 512a191.232 191.232 0 0 0-67.968-146.56A191.296 191.296 0 0 0 512 320a191.232 191.232 0 0 0-146.56 67.968C337.088 421.44 320 464.768 320 512a191.232 191.232 0 0 0 67.968 146.56C421.44 686.912 464.768 704 512 704c47.296 0 90.56-17.088 124.032-45.44zM512 960a448 448 0 1 1 0-896 448 448 0 0 1 0 896z"></path></svg>
        <span class="icon-box-text">帮助</span>
      </span>
      <el-divider class="header-divider" direction="vertical" />
    </div>
    <span class="olympic-title">返回冬奥官网</span>
  </div>
  <router-view/>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>

<style>
.header{
  height:80px;
  width:80%;
  position: relative;
  padding:0px;
  margin-left:10%;
  display: flex;

}
@media screen and (max-width:1500px)  {
  .header{
    width: 1200px !important;
    margin-left:150px !important;
  }

}
.header-title{
  position: absolute;
  left:10%;
  top:25px;
  font-size: 20px;
  font-width:bold;
}

.icon-content{
  position: absolute;
  left:55%;
  top:28px;
}
.icon-box{
  margin-right: 15px;
}
.header-icon{
  display: inline-block;
  width:18px;
  position: relative;
  top:3px;
}
.header-divider{
  font-weight: bold;
}
.olympic-title{
  position: absolute;
  left:75%;
  top:28px;
}
</style>

