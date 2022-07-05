import User from "../interfaces/Users";
import { Ref, ref } from "vue";

export class UserService {

  private user: Ref<User>;
  private users: Ref<Array<User>>;

  constructor() {     
    this.user = ref<User>({})
    this.users = ref<Array<User>>([])
  }

  getUser (): Ref<User> {
    return this.user;
  }

  getUsers (): Ref<User[]> {
    return this.users;
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
}

