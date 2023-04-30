use bevy::prelude::*;

// Component
#[derive(Component)]
struct Person;
#[derive(Component)]
struct Name(String);
#[derive(Resource)]
struct GreetTimer(Timer);

// Plugin
pub struct HelloPlugin;

impl Plugin for HelloPlugin {
    fn build(&self, app: &mut App) {
        app.insert_resource(GreetTimer(Timer::from_seconds(2.0, TimerMode::Repeating)))
            .add_startup_system(add_people)
            .add_system(greet_people);
    }
}

fn add_people(mut commands: Commands) {
    commands.spawn((Person, Name("Elaina Proctor".to_string())));
    commands.spawn((Person, Name("Renzo Hume".to_string())));
    commands.spawn((Person, Name("Zayna Nieves".to_string())));
}

fn greet_people(
    time: Res<Time>, mut timer: ResMut<GreetTimer>, query: Query<&Name, With<Person>>) {
    // update our timer with the time elapsed since the last update
    // if that caused the timer to finish, we say hello to everyone
    if timer.0.tick(time.delta()).just_finished() {
        for name in query.iter() {
            println!("hello {}!", name.0);
        }
    }
}

fn main() {
    App::new()
        .add_plugins(DefaultPlugins.set(WindowPlugin {
            // Windowing: WindowDescriptor renamed to Window.
            window: WindowDescriptor { 
                width: 140.0,
                height:140.0,
                title: "Game of Life".to_string(),
                ..default()
            },
            ..default()
        }))
        .add_plugin(HelloPlugin)
        .run();
}
