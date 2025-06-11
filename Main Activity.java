public class MainActivity extends AppCompatActivity {
    ListView listView;
    FloatingActionButton fab;
    TaskDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.taskListView);
        fab = findViewById(R.id.fabAdd);
        db = new TaskDatabase(this);
        loadTasks();

        fab.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddEditTaskActivity.class));
        });
    }

    private void loadTasks() {
        Cursor cursor = db.getAllTasks();
        List<Task> taskList = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            String deadline = cursor.getString(3);
            taskList.add(new Task(id, title, description, deadline));
        }

        TaskAdapter adapter = new TaskAdapter(this, taskList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }
}
