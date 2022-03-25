<template>
  <div class="nav">
    <span @click="go('/home/mainPage/index')" :class="nav1" class="nav-item item-first">首页</span>
    <span @click="go('/home/mainPage/schedule')" :class="nav2" class="nav-item">赛程</span>
    <span @click="go('/home/mainPage/rank')" :class="nav3" class="nav-item">奖牌总榜</span>
    <span @click="go('/home/mainPage/worldMap')" :class="nav4" class="nav-item">奖牌地图</span>
  </div>
  <router-view/>
</template>

<script>
export default {
  name: "Nav",
  data(){
    return{
      nav1:false,
      nav2:false,
      nav3:false,
      nav4:false,
    }
  },
  methods:{
    go(path){
      this.$router.push(path);


      this.timer = setTimeout(()=>{   //设置延迟执行
        this.nav1 = this.nav2 =this.nav3 =this.nav4 = '';
        if(this.$route.path == '/home/mainPage/index'){
          this.nav1="active"
        }else if(this.$route.path == '/home/mainPage/schedule'){
          this.nav2 = "active";
        }else if(this.$route.path == '/home/mainPage/rank'){
          this.nav3 = "active";
        }else{
          this.nav4 = "active";
        }
      },100);


    }
  },
  mounted() {
    this.nav1 = this.nav2 =this.nav3 =this.nav4 = '';
    if(this.$route.path == '/home/mainPage/index'){
      this.nav1="active"
    }else if(this.$route.path == '/home/mainPage/schedule'){
      this.nav2 = "active";
    }else if(this.$route.path == '/home/mainPage/rank'){
      this.nav3 = "active";
    }else{
      this.nav4 = "active";
    }
  }
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