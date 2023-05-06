use bevy::prelude::*;
use bevy::window::WindowResolution;

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
            // * 0.9.1: Initalize Window Size
            // * 0.10.1: Rename WindowDescriptor to Window and so on.
            primary_window: Some(Window { 
                title: "My Bevy Game".to_string(),
                resolution: WindowResolution::new(140.0, 140.0),
                ..default()
            }),
            ..default()
        }))
        .add_plugin(HelloPlugin)
        .run();
}
