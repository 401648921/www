<template>
  <el-card class="box-card MedalCard">
      <div class="countryName">中国</div>
      <div class="medalRank">金牌第三名</div>
      <div class="medal-content">
        <span class="medal-title">金牌:</span>
        <span class="medal-num">17</span>
        <span class="medal-icon gold-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
      <div class="medal-content">
        <span class="medal-title">银牌:</span>
        <span class="medal-num">17</span>
        <span class="medal-icon silver-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
      <div class="medal-content">
        <span class="medal-title">铜牌:</span>
        <span class="medal-num">17</span>
        <span class="medal-icon copper-icon"><svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M512 896a256 256 0 1 0 0-512 256 256 0 0 0 0 512zm0 64a320 320 0 1 1 0-640 320 320 0 0 1 0 640z"></path><path fill="currentColor" d="M576 128H448v200a286.72 286.72 0 0 1 64-8c19.52 0 40.832 2.688 64 8V128zm64 0v219.648c24.448 9.088 50.56 20.416 78.4 33.92L757.44 128H640zm-256 0H266.624l39.04 253.568c27.84-13.504 53.888-24.832 78.336-33.92V128zM229.312 64h565.376a32 32 0 0 1 31.616 36.864L768 480c-113.792-64-199.104-96-256-96-56.896 0-142.208 32-256 96l-58.304-379.136A32 32 0 0 1 229.312 64z"></path></svg></span>
      </div>
  </el-card>
</template>

<script>
export default {
  name: "CountryMedalCard",
  data(){
    return{
      rankArray:['一','二','三','四','五','六','七','八','九','十']
    }
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
</style>