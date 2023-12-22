import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object NetworkConstants {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://pxirsujsuyrqhmwbegrx.supabase.co/rest/v1/Music",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InB4aXJzdWpzdXlycWhtd2JlZ3J4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDMwNTc4NzgsImV4cCI6MjAxODYzMzg3OH0.IFf8tIJkqW-ruZz9nXG-D2kp3Hm6kmZipP--cQWDm00"
    ) {
        install(Postgrest)
    }
}