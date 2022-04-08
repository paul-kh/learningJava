import java.util.Objects;

public class Movie {

        private String name;
        private String actor;

        public Movie(String name, String actor) {
            this.name = name;
            this.actor = actor;
        }

        public String getName() {
            return name;
        }

        public String getActor() {
            return actor;
        }

        @Override
        public String toString() {
            return "{" + name + ", " + actor + "}";
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, actor);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }

            if (!(other instanceof Movie)) {
                return false;
            }

            Movie otherMovie = (Movie) other;

            if (otherMovie.name.equals(this.name) &&
                    otherMovie.actor.equals(this.actor)) {
                return true;
            }

            return false;
        }
}
