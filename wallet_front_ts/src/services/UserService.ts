import User from "../interfaces/Users";
import { Ref, ref } from "vue";
import UserDTO from "@/interfaces/UserDTO";
import CreateUserDTO from "../models/CreateUserDTO"


export class UserService {

  private user: Ref<User>;
  private userDTO: Ref<UserDTO>;
  private users: Ref<Array<User>>;


  constructor() {     
    this.user = ref<User>({})
    this.userDTO = ref <UserDTO>({})
    this.users = ref<Array<User>>([])
  
  }

  getUser (): Ref<User> {
    return this.user;
  }

  getUsers (): Ref<User[]> {
    return this.users;
  }

  getUserDTO (): Ref<UserDTO>{
    return this.userDTO;
  }



  async fetchAll(): Promise<void> {

    try {

      const url = 'http://localhost:4000/all-users'
      const response = await fetch(url)
      const json  = await response.json()
      this.users.value = json

    } catch (error) {

        console.log(error)
    }
  }

  async fetchById(id: any): Promise<void> {
    try {

      const url = `http://localhost:4000/user/${id}`
      const response = await fetch(url)
      const json  = await response.json()
      this.user.value = await json

    } catch (error) {

        console.log(error)
    }
  }

  async createUser(user: CreateUserDTO): Promise<any> {
    
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user)
    };
    const response = await fetch(`http://localhost:4000/create-user`, requestOptions);
    const data = await response.json();
    user = data.id;

  }


 
   
}

