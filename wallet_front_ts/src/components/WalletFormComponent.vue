<template>
  <div class="form-group">

    <div>
      <label for="name">Currency: </label>
      <select v-model="currency">
      <option disabled value="">Select Currrency</option>
      <option value="BTC">BTC</option>
      <option value="ETH">ETH</option>
      <option value="ADA">ADA</option>
      </select>
    </div>
    <br>
    <div>
      <label for="amount">Amount: </label>
      <input type="number" v-model="amount" placeholder="amount" >
    
    </div>
   </div>

   <div class="addWallet">
     <button v-on:click="addWallet()">Add Wallet</button>

   </div>
</template>

<script lang="ts">
import { defineComponent, onMounted } from 'vue';
import { WalletService } from '../services/WalletService';
import AddWalletDTO from '../models/AddWalletDTO';
import { useRoute } from 'vue-router';
import { UserService } from '@/services/UserService';


export default defineComponent ({
    name: 'walletForm',

    

    methods: {

        addWallet(){
            const walletService = new WalletService();
            const currency = this.currency;
            const amount = this.amount;
            const userId = this.id
            
            console.log(currency, amount);

            const newWallet = new AddWalletDTO(currency, amount, userId);
            console.log(newWallet)
            walletService.addWallet(newWallet).then(()=>{
               window.location.reload();
            })
            

        
        }
     },

    setup () {
          const currency = ""
          const amount = 0
          const { id } = useRoute().params;
          
        onMounted(async () => {            
        })

    
    return {
        currency,
        amount,
        id
    }
    }

});
</script>

<style>

.form-group{
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: center; 

}

.addWallet{
  display: flex;
  align-content: center;
  margin: 5px;
  
}

</style>