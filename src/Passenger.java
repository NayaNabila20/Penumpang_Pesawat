package PM;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        head = null;
    }

    // Metode untuk menambah penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
        System.out.println(name + " telah ditambahkan ke dalam penerbangan.");
    }

    // Metode untuk menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang yang terdaftar.");
            return;
        }

        // Jika penumpang yang ingin dihapus berada di awal daftar
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari penerbangan.");
            return;
        }

        // Mencari penumpang di daftar
        Passenger current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
        } else {
            current.next = current.next.next;
            System.out.println(name + " telah dihapus dari penerbangan.");
        }
    }

    // Metode untuk menampilkan semua penumpang
    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang yang terdaftar.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Alice");
        flight.addPassenger("Bob");
        flight.addPassenger("Charlie");

        flight.displayPassengers();

        flight.removePassenger("Bob");
        flight.displayPassengers();

        flight.removePassenger("David"); // Penumpang tidak ada
    }
}

