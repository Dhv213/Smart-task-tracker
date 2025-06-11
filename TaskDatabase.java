public class TaskDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "tasks_db";
    private static final int DB_VERSION = 1;

    public TaskDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tasks (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "title TEXT, description TEXT, deadline TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    public void addTask(String title, String description, String deadline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("description", description);
        values.put("deadline", deadline);
        db.insert("tasks", null, values);
        db.close();
    }

    public Cursor getAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM tasks", null);
    }

    // Add update and delete functions if needed
}
