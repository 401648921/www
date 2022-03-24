<template>
  <div class="map-content">
    <World></World>
  </div>
</template>

<script>
import World from '@/components/Common/World'
export default {
  name: "WorldMap",
  components:{World},


}
</script>

<style scoped>
.map-content{
  width:65%;
  height:800px;
  margin-left:15%;
  margin-top:20px;
}
@media screen and (max-width: 1500px){
  .map-content{
    width:975px !important;
    margin-left: 225px !important;
  }

}
</style>