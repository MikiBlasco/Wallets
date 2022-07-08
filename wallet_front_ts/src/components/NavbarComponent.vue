<template>
  <nav>
    <router-link to="/">Home</router-link>
  </nav>

</template>

<script lang="ts">

import { defineComponent, onMounted } from 'vue';

export default defineComponent({
    
    name: 'NavBar'

});
</script>

<style>
nav{
  margin: 16px;
}
</style>