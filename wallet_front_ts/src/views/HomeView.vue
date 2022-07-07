<template>
  <div class="home">
    
  <user-component></user-component>
  <hr/>
  <user-form-component></user-form-component>
  

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
  justify-content: center;
  align-items: center;
}

.user{
  border: 1px solid black;
  padding: 5px;
  margin: 5px;
}

.user-info{
  background-color: lemonchiffon;
}

.wallet{
  background-color: blanchedalmond;
  border: 1px solid grey;
  border-radius: 8px;
}



</style>
