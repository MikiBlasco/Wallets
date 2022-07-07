<template>
  <div>
    <div class="user" v-for="user in users" :key="user.id">
      <ul class="user-info">
        <li>Name: {{ user.name }}</li>
        <li>Email:{{ user.mail }}</li>
        <router-link :to="`/user/${user.id}`"> See wallets </router-link>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { UserService } from '@/services/UserService';
import { defineComponent, onMounted } from 'vue';

export default defineComponent ({
    name: 'UserComponent',   

    setup () {

    const service = new UserService()
    const users = service.getUsers()

    onMounted(async () => {
      await service.fetchAll()
    })

    return {
      users,
    }
  },

});
</script>

<style></style>
