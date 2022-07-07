<template>
  <div class="home">
    
    <div class="userForm">
      <user-form-component></user-form-component>
    </div>

    <div class="users">      
      <user-component></user-component>      
    </div>

    
  </div>
</template>

<script lang="ts">
import { defineComponent} from 'vue';
import  UserFormComponent  from "../components/UserFormComponent.vue"
import UserComponent from '../components/UserComponent.vue';


export default defineComponent({

  name: "HomeView",

  components: {
    UserComponent,
    UserFormComponent,
  },
  
})

</script>

<style>

.home{
  display: flex;
  flex-direction: column;
  align-items:flex-start;
  margin: 10px;
  width: 400px;
}

.users{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 1px rgb(245, 234, 234) solid;
  border-radius: 8px;
  margin: 5px;
}

.userForm {
  border: 1px grey solid;
  border-radius: 8px;
  padding: 10px;
  margin: 5px;

}

.user{
  padding: 5px;
  margin: 5px;
  border-radius: 8px;
  background-color: rgb(208, 208, 230);
  text-decoration: none;
}

.user-info{
  background-color: rgba(253, 253, 253, 0.411);
  border-radius: 8px;
}

.wallet{
  background-color: rgb(245, 243, 240);
  border-radius: 8px;

}



</style>
