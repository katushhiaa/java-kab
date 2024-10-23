
const { MongoClient, ServerApiVersion } = require('mongodb');
const uri = "mongodb+srv://anurievakateryna:ZsclKmG0jmLF8fiU@laboratorki.jbxsh.mongodb.net/?retryWrites=true&w=majority&appName=Laboratorki";

const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  }
});

async function run() {
  try {
    await client.connect();
    await client.db("admin").command({ ping: 1 });
    console.log("Pinged your deployment. You successfully connected to MongoDB!");


    const db = client.db("Laboratorki");

// --------------------- insert --------------------

    /*const teachers = db.collection("teachers");
    const teacherDocuments = [
      { name: "Олександр", surname: "Іванов", cafedra: "Інформатика" },
      { name: "Марія", surname: "Петренко", cafedra: "Математика" },
      { name: "Юрій", surname: "Сидоренко", cafedra: "Фізика" },
      { name: "Ірина", surname: "Коваль", cafedra: "Хімія" },
      { name: "Карина", surname: "Каринова", cafedra: "Географія" },
      { name: "Іван", surname: "Іванов", cafedra: "Історія" },
      { name: "Дмитро", surname: "Жданов", cafedra: "Бази даних" },
      { name: "Інна", surname: "Петрова", cafedra: "Астрономія" },
      
    ];
    await teachers.insertMany(teacherDocuments);
    console.log("Викладачі успішно додані");

    const classrooms = db.collection("classrooms")
    const classroomDocuments = [
        { numberClassroom: "101", typeOfClassroom: "Лекційна", numberOfSits: 80 },
        { numberClassroom: "102", typeOfClassroom: "Практична", numberOfSits: 25 },
        { numberClassroom: "103", typeOfClassroom: "Комп'ютерний клас", numberOfSits: 20 },
        { numberClassroom: "104", typeOfClassroom: "Семінарська", numberOfSits: 50 },
        { numberClassroom: "103", typeOfClassroom: "Лабораторна", numberOfSits: 15 },
        ];
    await classrooms.insertMany(classroomDocuments);
    console.log("Аудиторії успішно додані");

    const studentgroups = db.collection("studentgroups");
    const groupDocuments = [
        { group_number: "243", specialization: "Комп'ютерні науки", facultati: "Інформатики", numberOfStudents: 25 },
        { group_number: "244", specialization: "Математика", facultati: "Математичний", numberOfStudents: 20 },
        { group_number: "245", specialization: "Фізика", facultati: "Фізичний", numberOfStudents: 15 },
        { group_number: "246", specialization: "Англійська мова", facultati: "Філологічний", numberOfStudents: 35 },
        { group_number: "247", specialization: "Юрист", facultati: "Юридичний", numberOfStudents: 40 },
        ];
    await studentgroups.insertMany(groupDocuments);
    console.log("Групи студентів успішно додані");

    const disciplines = db.collection("disciplines");
    const disciplineDocuments = [
        { name: "Інформатика", typeOfLesson: "Лекція" },
        { name: "Математика", typeOfLesson: "Практика" },
        { name: "Фізика", typeOfLesson: "Лабораторна" },
        { name: "Хімія", typeOfLesson: "Семінар" },
        { name: "Географія", typeOfLesson: "Лекція" },
        { name: "Історія", typeOfLesson: "Лабораторна" },
        { name: "Бази даних", typeOfLesson: "Практична" },
        { name: "Астрономія", typeOfLesson: "Семінар" },
    ];
    await disciplines.insertMany(disciplineDocuments);
    console.log("Дисципліни успішно додані");*/

    /*const schedule = db.collection("schedule");

    const group243 = await db.collection("studentgroups").findOne({ group_number: "243" });
    const group244 = await db.collection("studentgroups").findOne({ group_number: "244" });
    const group245 = await db.collection("studentgroups").findOne({ group_number: "245" });
    const informatics = await db.collection("disciplines").findOne({ name: "Інформатика" });
    const math = await db.collection("disciplines").findOne({ name: "Математика" });
    const physics = await db.collection("disciplines").findOne({ name: "Фізика" });
    const room101 = await db.collection("classrooms").findOne({ numberClassroom: "101" });
    const room102 = await db.collection("classrooms").findOne({ numberClassroom: "102" });
    const room103 = await db.collection("classrooms").findOne({ numberClassroom: "103" });
    const teacherIvanov = await db.collection("teachers").findOne({ surname: "Іванов" });
    const teacherPetrenko = await db.collection("teachers").findOne({ surname: "Петренко" });
    const teacherSydorenko = await db.collection("teachers").findOne({ surname: "Сидоренко" });

    const scheduleDocuments = [
        {
          id_group: { "$ref": "studentgroups", "$id": group243._id },
          id_disciplines: { "$ref": "disciplines", "$id": informatics._id },
          id_classroom: { "$ref": "classrooms", "$id": room101._id },
          id_teacher: { "$ref": "teachers", "$id": teacherIvanov._id },
          timeOfLesson: "08:00",
          regularity: "Щотижня"
        },
        {
          id_group: { "$ref": "studentgroups", "$id": group244._id },
          id_disciplines: { "$ref": "disciplines", "$id": math._id },
          id_classroom: { "$ref": "classrooms", "$id": room102._id },
          id_teacher: { "$ref": "teachers", "$id": teacherPetrenko._id },
          timeOfLesson: "10:00",
          regularity: "Щотижня"
        },
        {
          id_group: { "$ref": "studentgroups", "$id": group245._id },
          id_disciplines: { "$ref": "disciplines", "$id": physics._id },
          id_classroom: { "$ref": "classrooms", "$id": room103._id },
          id_teacher: { "$ref": "teachers", "$id": teacherSydorenko._id },
          timeOfLesson: "12:00",
          regularity: "Щотижня"
        }
      ];
      
    await schedule.insertMany(scheduleDocuments);
    console.log("Розклад успішно доданий");*/


// ---------------------- delete ------------------

    /*await db.collection('teachers').deleteMany({});
    await db.collection('classrooms').deleteMany({});
    await db.collection('studentgroups').deleteMany({});
    await db.collection('disciplines').deleteMany({});*/

    /*await db.collection("teachers").deleteMany({ cafedra: "Хімія" });
    await db.collection("classrooms").deleteMany({ numberOfSits: { $lt: 19 } });
    await db.collection("studentgroups").deleteMany({ numberOfStudents: { $gt: 20 } });
    await db.collection("disciplines").deleteMany({ typeOfLesson: "Семінар" });
    await db.collection("schedule").deleteMany({ id_group: { "$ref": "studentgroups", "$id": group243._id } });*/


// ---------------- search --------------

//---звичайні запити
    /*const teachers = await db.collection("teachers").find({ cafedra: "Інформатика" }).toArray();
    console.log(teachers);

    const largeGroups = await db.collection("studentgroups").find({ numberOfStudents: { $gt: 30 } }).toArray();
    console.log(largeGroups);

    const lectureClassrooms = await db.collection("classrooms").find({ typeOfClassroom: "Лекційна" }).toArray();
    console.log(lectureClassrooms);*/

//---вкладені запити   

//1  вибірка розкладу для групи, яка має більше ніж 20 студентів

/*const scheduleForLargeGroups = await db.collection("schedule").aggregate([
    {
      $lookup: {
        from: "studentgroups",           
        localField: "id_group.$id",     
        foreignField: "_id",            
        as: "group"                      
      }
    },
    {
      $match: {
        "group.numberOfStudents": { $gt: 20 }
      }
    }
  ]).toArray();
  console.log(scheduleForLargeGroups);


//вибірка викладачів лекція
  const lectureTeachers = await db.collection("schedule").aggregate([
    {
      $lookup: {
        from: "disciplines",            
        localField: "id_disciplines.$id",
        foreignField: "_id",            
        as: "discipline"                 
      }
    },
    {
      $match: {
        "discipline.typeOfLesson": "Лекція" 
      }
    },
    {
      $lookup: {
        from: "teachers",               
        localField: "id_teacher.$id",    
        foreignField: "_id",             
        as: "teacher"                   
      }
    },
    {
      $unwind: "$teacher"               
    },
    {
      $project: {
        "teacher.name": 1,
        "teacher.surname": 1            
      }
    }
  ]).toArray();
  console.log(lectureTeachers);
  

  //вибірка аудиторій лекцій
  const classroomsForLectures = await db.collection("schedule").aggregate([
    {
      $lookup: {
        from: "disciplines",              
        localField: "id_disciplines.$id", 
        foreignField: "_id",              
        as: "discipline"                  
      }
    },
    {
      $match: {
        "discipline.typeOfLesson": "Лекція" 
      }
    },
    {
      $lookup: {
        from: "classrooms",              
        localField: "id_classroom.$id",   
        foreignField: "_id",              
        as: "classroom"                   
      }
    },
    {
      $unwind: "$classroom"               
    },
    {
      $project: {
        "classroom.numberClassroom": 1,
        "classroom.typeOfClassroom": 1    
      }
    }
  ]).toArray();
  console.log(classroomsForLectures);
  

  //---запити з обмеженням на результати підсумкових функції

  //підрахунок кількості викладачів у кожній кафедрі
  
  const teachersPerCafedra = await db.collection("teachers").aggregate([
    {
      $group: {
        _id: "$cafedra",
        totalTeachers: { $sum: 1 }
      }
    }
  ]).toArray();
  console.log(teachersPerCafedra);
  
  //максимальна кількість студентів у групі:
  const maxStudentsInGroup = await db.collection("studentgroups").aggregate([
    {
      $group: {
        _id: null,
        maxStudents: { $max: "$numberOfStudents" }
      }
    }
  ]).toArray();
  console.log(maxStudentsInGroup);

  //середня кількість місць в аудиторіях
  const avgSeatsInClassrooms = await db.collection("classrooms").aggregate([
    {
      $group: {
        _id: null,
        avgSeats: { $avg: "$numberOfSits" }
      }
    }
  ]).toArray();
  console.log(avgSeatsInClassrooms);*/
  

//----- агрегатні


//1
const scheduleAggregation = await db.collection("schedule").aggregate([
    {
      $lookup: {
        from: "studentgroups",           
        localField: "id_group.$id",      
        foreignField: "_id",             
        as: "group"                      
      }
    },
    {
     
      $match: {
        "group.numberOfStudents": { $gt: 20 } 
      }
    },
    {
      $lookup: {
        from: "classrooms",               
        localField: "id_classroom.$id",    
        foreignField: "_id",               
        as: "classroom"                    
      }
    },
    {
      $group: {
        _id: "$id_classroom.$id",          
        countLessons: { $sum: 1 },         
        classroom: { $first: "$classroom" } 
      }
    },
    {

      $sort: {
        countLessons: -1  
      }
    }
  ]).toArray();
  
  console.log(scheduleAggregation);  
  

// 2
const teacherAggregation = await db.collection("schedule").aggregate([
    {
      
      $lookup: {
        from: "disciplines",              
        localField: "id_disciplines.$id",
        foreignField: "_id",              
        as: "discipline"                  
      }
    },
    {
      $match: {
        "discipline.typeOfLesson": "Лекція" 
      }
    },
    {
      
      $lookup: {
        from: "teachers",                
        localField: "id_teacher.$id",     
        foreignField: "_id",             
        as: "teacher"                    
        }
    },
    {
      
      $unwind: "$teacher"  
    },
    {
      
      $group: {
        _id: "$id_teacher.$id",           
        countLessons: { $sum: 1 },        
        teacher: { $first: "$teacher" }   
      }
    },
    {
      
      $sort: {
        countLessons: -1  
      }
    }
  ]).toArray();
  
  console.log(teacherAggregation);  

// 3

const studentGroupAggregation = await db.collection("schedule").aggregate([
    {

      $lookup: {
        from: "disciplines",              
        localField: "id_disciplines.$id", 
        foreignField: "_id",              
        as: "discipline"                  
      }
    },
    {
      
      $match: {
        "discipline.name": { $in: ["Інформатика", "Математика"] }
      }
    },
    {
      
      $lookup: {
        from: "studentgroups",            
        localField: "id_group.$id",       
        foreignField: "_id",              
        as: "group"                       
      }
    },
    {
      $unwind: "$group"
    },
    {
      $group: {
        _id: "$id_group.$id",            
        avgStudents: { $avg: "$group.numberOfStudents" } 
      }
    },
    {
      $sort: {
        avgStudents: -1  
      }
    }
  ]).toArray();
  
  console.log(studentGroupAggregation);  
  
  

  } finally {
    await client.close();
  }
}
run().catch(console.dir);
