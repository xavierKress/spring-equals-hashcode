import java.util.HashSet;
import java.util.Set;

public class equalsHashcode {
    /*
    La classe User redéfinit equals et hashcode. Sans ça, on voit que les deux objets ne sont pas égaux car de base,
    equals compare les adresses mémoire. Une fois equals redéfinit, si on ne redéfinit pas hashcode, on peut toujours
    mettre les deux objets dans un set car l'unicité est vérifiée via le hashcode qui s'il n'est pas refédinit, est un
    hash de l'adresse mémoire. Pour empêcher de mettre deux objets égaux dans un set, ils doivent avoir le même hashcode,
    il faut donc redéfinir hashcode.
     */
    public static void main(String[] args) {
        User u1 = new User("Xavier");
        System.out.println("Hello "+u1.name);

        User u2 = new User("Xavier");
        System.out.println("Hello "+u2.name);

        System.out.println("Test equals : "+u1.equals(u2));


        System.out.println("hashcode u1 : "+u1.hashCode());
        System.out.println("hashcode u2 : "+u2.hashCode());

        Set<User> set = new HashSet();
        set.add(u1);
        set.add(u2);
        System.out.println("SET SIZE : "+set.size());
    }
}

class User {
    String name;

    public User(String name) {
         this.name = name;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    //@Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
