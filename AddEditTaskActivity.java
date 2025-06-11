public class AddEditTaskActivity extends AppCompatActivity {
    EditText titleInput, descInput, deadlineInput;
    Button saveButton;
    TaskDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        titleInput = findViewById(R.id.inputTitle);
        descInput = findViewById(R.id.inputDescription);
        deadlineInput = findViewById(R.id.inputDeadline);
        saveButton = findViewById(R.id.btnSave);
        db = new TaskDatabase(this);

        saveButton.setOnClickListener(v -> {
            db.addTask(
                titleInput.getText().toString(),
                descInput.getText().toString(),
                deadlineInput.getText().toString()
            );
            finish();
        });
    }
}
