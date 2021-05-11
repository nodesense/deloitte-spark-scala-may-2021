object S42_Trait extends  App {
  // traits are interfaces
  // useful to define polymorphic behavior
  // we cannot create instance for trait
  trait Vehicle {
    // declare the behaviours
    def start();
    def stop();
  }

  trait Drivable {
    def drive();
  }

  trait LicenseRequired {
    def hasLicense(): Boolean
  }

  // can do, polymorhpic
  class Car extends Vehicle with Drivable  with LicenseRequired {
    def start() = {
      println("Starting car")
    }

    def stop() = {
      println("Stopping car")
    }

    def drive() = println("Driving")

    def hasLicense() = true
  }

  class Truck extends Vehicle {
    def start() = {
      println("starting truck")
    }
    def stop() = {
      println("stopping truck")
    }
  }

  val v1: Vehicle = new Car()
  val v2: Vehicle = new Truck()
  //error, since Truck is not implementing drivable trait
  // val v3: Drivable = new Truck()

  def checkVehicle(v: Vehicle) = {
    v.start()
    v.stop()
  }

  checkVehicle(v1)
  checkVehicle(v2)

  val car1 = new Car()
  val d: Drivable = car1;
  val v3: Vehicle = car1;

  // error
  //val d2: Drivable = v1; // v1 is instance of car

  // scala type casting, cast one type to another tpye
  // if type is not compatible, scala shall throw compilation error
  val d2: Drivable = v1.asInstanceOf[Drivable]
  d2.drive()

  // throw error
  val d3: Drivable = v2.asInstanceOf[Drivable]; // no compile time error, but throw runtime cast error

}
