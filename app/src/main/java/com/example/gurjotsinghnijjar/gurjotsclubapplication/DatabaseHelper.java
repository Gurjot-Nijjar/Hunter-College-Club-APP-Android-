package com.example.gurjotsinghnijjar.gurjotsclubapplication;

/**
 * Created by Gurjot Singh Nijjar on 5/5/2018.
 * SQLite Data Base Helper class creates a database, creates a table, and provides methods to change the table
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import static java.lang.String.*;

public class DatabaseHelper extends SQLiteOpenHelper{

    public SQLiteDatabase DB;
    public String DBPath;
    public static String DBName = "sample";
    public static final int version = '1';
    public static Context currentContext;
    public static String tableName = "H_Club_2";

    public DatabaseHelper(Context context) {
        super(context, DBName, null, version);
        currentContext = context;
        DBPath = "/data/data/" + context.getPackageName() + "/databases";
        createDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub

    }

    private void createDatabase() {
        boolean dbExists = checkDbExists();

        if (dbExists) {
// do nothing
        } else {
            DB = currentContext.openOrCreateDatabase(DBName, 0, null);
            DB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + " (Club_Name TEXT, Club_Information TEXT," + " Club_Email TEXT, Event_Title TEXT, Event_Date TEXT);");

            DB.execSQL("INSERT INTO " + tableName + " Values ('Accounting Society','The name of the student-run organization shall be the Accounting Society of Hunter College (hereinafter named HCAS). The purpose of this organization is to provide Hunter College students interested in and pursuing an Accounting degree, with the necessary support to assist them with their transition from students to working professionals. This organization shall coordinate a variety of events and activities all geared towards exposing students to different opportunities in the Accounting field. This organization, through specific events, shall also provide students with practical experience and additional knowledge that are essential for their growth and career advancement.','accountingsocietyhc@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Africana Puerto Rican/Latino Studies Club','The purpose of this organization is to promote greater cohesion among AFRPL majors and minors as well as increased awareness of pertinent issues by the larger Hunter community. The Club aims to present an alternative analysis of the Black and Puerto Rican/Latino experience while broadening academic and professional interest in the disciplines. The Club will be a forum for students to discuss historical and contemporary issues pertinent to the AFPRL experience','afprl.hunter.club@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('American Medical Student Association','To enrich the academic and professional development of underrepresented minority pre-health students, and the undergraduate students, thereby equipping those with the knowledge, skills and experiences that will produce competitive candidates for professional health related programs, who are better prepared to become successful participants at various health and graduate professions. To increase underrepresented minority participation in all professional health and graduate related programs, with an emphasis on medicine. To provide opportunities that will render AMSA members knowledgeable of the admissions processes and allow a means of networking with other students at various levels. To provide opportunities to develop leadership, foster mentoring relationships, and to develop strong membership bonds. To facilitate interactions between AMSA members, pre-professional advisors and faculty/staff members of professional schools, enabling for more effective means of recruitment, identification of mentors and resources, and matriculation intro to institutions.','HunterAMSA@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Anthropology Club','Primary among the objectives of the Anthropology Club is to provide a forum for the discussion of issues relating to the discipline of anthropology, including, but not limited to the sub-disciplines of sociocultural anthropology, biological/physical anthropology, archaeology, and linguistics. Dissemination of current information and event in the city relating to these fields is also a goal of the organization. It is also the intent of the club to offer student peer-advising to students of the club and department in each of the four fields, due to their distinctive and diverse natures. Advising will focus on explaining the nature of the fields, opportunities, and preparation for graduate study.','hunteranthropologyclub@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Arab Studies Club','The Arab Studies Club seeks to engage the Hunter community with the Arab region - such as its various cultures, histories and political circumstances. As a club, we will hold events to raise awareness, enhance the understanding of, and connect students with the dynamic of the region. We will also empower and give a voice to Arab students by providing them with this platform on campus to represent themselves.','arabstudiesclubhunter@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Association of Computing Machinery at Hunter College','The Chapter is organized and will be operated exclusively for educational and scientific purposes and, in furtherance thereof, specific objectives are: A. To promote an increased knowledge of the science, design, development, construction,language, and applications of modern computing machinery; B. To promote a greater interest in computing machinery and its applications; and C. To provide a means of communication between person having interest in computingmachinery.','huntercollege.acm.chapter@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Biology','To enrich the academic and professional development of underrepresented minority pre-health students, and the undergraduate students, thereby equipping those with the knowledge, skills, and experiences that will produce competitive candidates for professional health-related programs, who are better prepared to become successful participants in various health and graduate professions.','PH.ResearchInitiative@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Economics Club','The Economics Club wants to create an open and welcoming space where members can share and enhance their knowledge of economics.','huntereconclub@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Geography Club','The purpose of the Geo Club is to stimulate interest in the geosciences and the environment while promoting the personal and professional development of its student members; to act as a liaison between Geography and Geology majors and minors of Hunter College, CUNY; and to promote and sponsor club activities, which include but are not limited to: Field excursions to areas of regional geologic or geographic significance; Speakers programs in Earth Sciences topics; Encouraging student participation and attendance at professional conferences; and Planning social gatherings that foster friendships among students, as well as informal student/faculty interactions in order to strengthen and expand the university experience of our student-members.','huntergeoclub@gmail.com','Trip to Museum, email for details','2018-06-10');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('German Club','The purpose of the German Club is to provide Hunter students an opportunity to learn more about the German language and German culture outside the classroom.  We will offer this opportunity via events on-campus including themed meetings and film screenings, for example and throughout New York City at museums, theaters, operas, etc.', 'germanclubofhuntercollege@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Linguistics Association','The purpose of the Linguistics Association is to foster a sense of community among Hunter students who are studying or interested in linguistics, and to provide a forum for scholarly discussion and debate regarding the scientific study of language.',' hc.linguisticsclub@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Medical Laboratory Science','The purpose of the Club is to act on behalf of all its members, providing general knowledge of the continuing technological advances within the clinical statuettes of the medical laboratory profession. This will be achieved through holding various workshops and contact sessions that will offer pertinent information of these previously stated advances.','mlsclubhunter@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Minority Association for Pre-Medical Students', 'The purpose of this club is to provide minority pre-medical students with networking skills, academic support and mentor-ship to attempt to fulfill the goal of diversifying the healthcare professions.','huntermaps@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('National Student Nurses Association',' The purpose of the association is to provide activities and functions that contribute fundamentally and professionally to nursing education; to encourage collaboration, cohesion and unity within the school community; to uphold the values of the nursing profession; to serve and protect the interests of the student body; and to aid in the holistic development of future nurses in order to deliver the highest quality healthcare possible.','hbstudentnursing@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Dental Society',' The CUNY Hunter PDS is dedicated to supporting the professional growth and career development of the students of Hunter College interested in the field of dentistry.  As a society, we are committed to promoting fellowship between students, serving our members by increasing their knowledge of the dental profession, and serving the community through volunteer projects and various outreach programs.',' Pds.hunter@gmail.com ','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Health Organization','The purpose of the Pre-Health Organization is to 1. Provide Pre-Health students with information and skills necessary to make them strong applicants for pre-health graduate schools. 2. To be the conduit between the pre-health students, advisor and administrators of various health professional schools. 3. To build a network and team of students that will benefit the community through various acts and community service programs.','hunterprehealth@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Health Post-Bacc Community','The purpose of the Pre- Health Post- Bacc Community is to provide pertinent resources, support, information, guidance, and a sense of community to current and prospective Post- Bacc students. Our community offers a peers perspective on life at Hunter as a Post- Bacc.','hunterpostbaccs@gmail.com','General Event (1 - 2 pm) at Hunter','2018-05-23');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Law Society','The purpose of this organization is to provide assistance for students interested in law, and to provide activities and program dealing with or related to the field of law, and preparing students for law school applications and admissions.','huntercollege.prelawsociety@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Optometry Society','The purpose of this organization is to enrich the academic and professional development of Hunter College students who are interested in the field of optometry. This club is for both students who aspire for a potential career in optometry or are just looking for a way to broaden their career options. The means by which this organization will achieve the academic enrichment of its members will be by providing them with an abundance of knowledge, professional resources, experiences, and skills. Different shadowing opportunities and research programs related to this field will be offered to the clubs members. This club also plans on providing first-hand experience to its members by adding a community service component.','HunterPreOptometry@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Pre-Veterinary Club','The purpose of this club is to help and guide students interested in pursuing a career in the field of veterinary medicine. This may be done in many different way such as trips, tours, guest speakers, and supplies. It is in the clubs interest to help members understand and learn of different fields in veterinary medicine and encourage them to pursue it. Support is a priority within the club and its members. The veterinary field is not just a future career, it is a family that is built now until beyond retirement. Veterinarians must be able to ask other veterinarians for suggestions in order to approach a difficult case from a different point of view. Therefore this club is meant to build friendships and future connections.','hunterprevet@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Psychology Club','The purpose of the Psychology Club is to facilitate a cohesive social group aimed at providing students with an opportunity to gain a greater appreciation for the discipline of psychology, and to facilitate the dissemination of relevant information for matters of concern to members.','HunterPsychCollective@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Society for Physics and Astronomy','The purpose of SPA is to encourage and facilitate the knowledge and understanding of Physics and Astronomy in varying formal and informal settings as well as hold activities that increase interest in and knowledge of both aforementioned fields.','hunterphysicsclub2@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Society of Bioethics and Medicine',' The purpose of this club is to bring awareness about ethical issues in medicine. We plan on having physicians and professors come in to speak about controversial topics that deal with medicine and human values. Topics for discussion will include end-of- life care, patient rights, genetic testing, and stem cell research.','bioethicsandmedicine@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('African Student Union',' The goal of this club is to create a safe environment for the students of Africa. This includes the countries above and below the Sub-Saharan desert, as well as the African Diaspora. We aim to educate, unite, and excite the students of the rich history of Africa, while promoting awareness of African related issues in the Hunter College community.','asuhuntercollege@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Artemis Hellenic','The Artemis Hellenic Club of Hunter Colleges purpose is to promote and celebrate Greek culture and history within the Hunter College community.','artemishellenic.hc@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('Asians Students In Action',' The purpose of Asian Students in Action shall be to: 1 aid the growth and development of Hunter College collegiate students through culturally, socially, and academically focused programming about the Asian community, 2 provide a positive learning environment for students, faculty, and staff at Hunter College, 3 promote diversity and unity within the Hunter College community, 4 provide community service, campus involvement, and professional development opportunities to its members, 5  increase the visibility and involvement of Asian students on campus and in the surrounding community and 6 provide an opportunity for students to come together and discuss issues pertaining to Asia.','AsiaAtHC@gmail.com','Pizza Day (3 - 5 pm) at Hunter','2018-05-18');");
            DB.execSQL("INSERT INTO " + tableName + " Values ('South Asian Cultural Club','The purpose of the South Asian Culture Club is to bring together the South Asian community of Hunter College.  Not only do we welcome students of South Asian descent, but we encourage all students to take part in all of our social events.  We provide a basis of cultural awareness through dance, film, music and various ethnic events. We want to ensure unity amongst students from all different backgrounds to raise school spirit.','sacchunter68@gmail.com','End of the Year (7 pm  - 12 am) at Hunter','2018-05-25');");


        }
    }

    private boolean checkDbExists() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DBPath + DBName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

// database does't exist yet.

        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }
}


/*
public class DatabaseHelper extends SQLiteOpenHelper {
    //Database
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="HunterClubs.db";

    //Table club entries
    private static final String TABLE_NAME = "Clubs";

    private static final String CLUB_NAME ="CLUB_NAME";
    private static final String CLUB_INFORMATION = "CLUB_INFORMATION";
    private static final String CLUB_EMAIL ="CLUB_EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create the SQLite table for constraints
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + "("
                + CLUB_NAME + " TEXT "
                + CLUB_INFORMATION + " TEXT"
                + CLUB_EMAIL + "TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE); //Execute SQL command to create a table with the proper fields
    }

    //Create the database or replace it
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //If the table already exists then delete it
        onCreate(sqLiteDatabase); //Call onCreate to create the table
    }

    /*

    public void CreateTable() {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CLUB_NAME, "Chinese Christian Fellowship");
        values.put(CLUB_INFORMATION, "To provide a place for Christian students of Hunter College to have weekly meetings. To help the members to understand more about Christianity. To build up one another.To introduce Christianity to the Chinese students of Hunter College.");
        values.put(CLUB_EMAIL, "huntercollegeccf@gmail.com");
        db.insert(TABLE_NAME, null, values); //Update and insert into table
        values.put(CLUB_NAME, "Hillel");
        values.put(CLUB_INFORMATION, "To enrich the lives of Jewish undergraduate students. We are dedicated to creating a pluralistic, welcoming an inclusive environment for Jewish college students where they are encouraged to grow intellectually, spiritually, and socially.\n");
        values.put(CLUB_EMAIL, "hunterhillel@gmail.com");
        db.insert(TABLE_NAME, null, values); //Update and insert into table
        db.close();
    }
*/



