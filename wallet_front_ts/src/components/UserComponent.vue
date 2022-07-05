<template>

<div>
    <h1> {{ saludo.toLocaleUpperCase() }} </h1>
    <button onclick="getUsers()">Show Users</button>
</div>

</template>

<script lang="ts">

export default {

    
    data(){
        return {
            saludo: "saludo",
            users: null,
        }
    },
    

}
</script>

<style>

</style>