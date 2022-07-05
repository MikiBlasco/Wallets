<template>
  <div class="home">
    
    <div class="user"
    v-for="user in users" 
    :key="user.id" 
    >  
    User
    <ul class="user-info">
      <li>Name: {{ user.name }}</li>
      <li>Email:{{ user.mail }}</li>
      <router-link :to="`/user/${user.id}`">
      See wallets
      </router-link>

     
    </ul>
      <div 
      v-for="wallet in user.walletList"
      :key="wallet.id" 
      >
      <ul class="wallet">
        {{ wallet.currency_name }} Wallet:
        <li> Amount: {{ wallet.currency_amount }} {{ wallet.currency_name }} </li>
        <li> Value USD: ??? </li>
      </ul>

      </div> 

    </div>

  </div>
</template>

<script lang="ts">
//import { Options, Vue } from 'vue-class-component';
import { defineComponent, onMounted } from 'vue';
import { UserService } from "../services/UserService"
//import UserComponent from '@/components/UserComponent.vue';


export default defineComponent({

  name: "HomeView",

  setup () {

    const service = new UserService()
    const users = service.getUsers()
    const user = service.getUser()

    onMounted(async () => {
      await service.fetchAll()
    })


    return {
      users
    }
  }
  
})

</script>

<style>

.home{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.user{
  border: 1px solid black;
  padding: 5px;
  margin: 5px;
}

.user-info{
  border: 1px solid blue;
}

.wallet{
  background-color: blanchedalmond;
  border: 1px solid grey;
  border-radius: 8px;
}



</style>
