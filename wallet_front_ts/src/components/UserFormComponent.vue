<template>

 <div class="form-group">
    <div>
      <label for="name">Name: </label>
      <input type="text" v-model="name" placeholder="Your name">
    </div>
    <div>
      <label for="mail">Mail: </label>
      <input type="text" v-model="mail" placeholder="Your mail" >
    </div>
    <div>
      <label for="password">password: </label>
      <input type="text" v-model="password" placeholder="Your mail" >
    </div>
    <hr>

 </div>


 <button v-on:click="addUser()">Add User</button>


</template>

<script lang="ts">
import { defineComponent, onMounted } from 'vue';
import { UserService } from '@/services/UserService';
import  CreateUserDto  from "../models/CreateUserDTO"

export default defineComponent ({
    name: 'userForm',
   

        methods: {

      addUser(){
        const service = new UserService();
        const name = this.name;
        const mail = this.mail;
        const password = this.password;
        console.log(name, mail, password)

        const newUser = new CreateUserDto (name, mail, password)
        console.log(newUser)
        service.createUser(newUser)
        
      }
    },

    setup () {

       onMounted(async () => {
    })
    

    return {
        name: '',
        mail: '',
        password: '',
      }

  

    },

  
    
  

});
</script>

<style></style>
