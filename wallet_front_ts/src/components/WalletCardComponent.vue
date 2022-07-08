<template>
   
   <h1>{{ test }}</h1>

  
</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue"

export default defineComponent ({
 
 name : "walletCard",
 

 data () {
   return {
    test:  'test2'
   }

 }


});
</script>

<style>

</style>