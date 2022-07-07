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
    <div>
      <label for="amount">Amount: </label>
      <input type="number" v-model="amount" placeholder="amount" >
    </div>

    <hr>

 </div>

 <button v-on:click="addWallet()">Add Wallet</button>
</template>

<script lang="ts">
import { defineComponent, onMounted } from 'vue';
import { WalletService } from '../services/WalletService';
import AddWalletDTO from '../models/AddWalletDTO';
import { useRoute } from 'vue-router';


export default defineComponent ({
    name: 'walletForm',

    methods: {

        addWallet(){
            const service = new WalletService();
            const currency = this.currency;
            const amount = this.amount;
            const userId = this.id
            
            console.log(currency, amount);

            const newWallet = new AddWalletDTO(currency, amount, userId);
            console.log(newWallet)
            service.addWallet(newWallet);
        
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

</style>