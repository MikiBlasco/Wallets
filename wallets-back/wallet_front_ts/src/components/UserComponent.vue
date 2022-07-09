<template>
  <div class="users-container">
    <h4 style="text-align: center">Users</h4>
    <div class="user" v-for="user in users" :key="user.id">
      <ul class="user-info">
        <li>Name: {{ user.name }}</li>
        <li>Email:{{ user.mail }}</li>
        <router-link :to="`/user/${user.id}`" style="text-decoration:none"> See wallets </router-link>
        <button class="button1" v-on:click="deleteUser(user)">delete</button>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { UserService } from '@/services/UserService';
import { defineComponent, onMounted } from 'vue';
import { WalletService } from '../services/WalletService';

export default {
    name: 'UserComponent',  


    setup () {

    const service = new UserService()
    const users = service.getUsers()

    onMounted(async () => {
      await service.fetchAll()
      //await walletService.getUsdPrice2();
    })

     function deleteUser(user: any) {
       service.deleteUser(user.id).
       then(()=>{
        service.fetchAll();
       })
    }

    return {
      users,
      deleteUser
    }
  },

};
</script>

<style></style>
