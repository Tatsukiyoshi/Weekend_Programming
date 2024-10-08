use bevy::prelude::*;

// for Windows Size
use bevy::window::WindowResolution;

// for Windows Icon
use bevy::winit::WinitWindows;
use bevy::window::PrimaryWindow;
use winit::window::Icon;

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
            .add_systems(Startup, add_people)
            .add_systems(Update, greet_people);
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

pub fn set_window_icon(
    main_window: Query<Entity, With<PrimaryWindow>>,
    windows: NonSend<WinitWindows>,
) {
    let Some(primary) = windows.get_window(main_window.single()) else {return};

    let (icon_rgba, icon_width, icon_height) = {
        let image = image::open("emo_emoji_smile_smiley_happy_emoticon_face_icon_152131.png")
            .expect("Failed to open icon path")
            .into_rgba8();
        let (width, height) = image.dimensions();
        let rgba = image.into_raw();
        (rgba, width, height)
    };

    let icon = Icon::from_rgba(icon_rgba, icon_width, icon_height).unwrap();
    primary.set_window_icon(Some(icon));
}

fn main() {
    App::new()
        .add_plugins(DefaultPlugins.set(WindowPlugin {
            // * 0.9.1: Initalize Window Size
            // * 0.10.1: Rename WindowDescriptor to Window and so on.
            primary_window: Some(Window { 
                title: "My Bevy Game".to_string(),
                resolution: WindowResolution::new(300.0, 200.0),
                ..default()
            }),
            ..default()
        }))
        .add_systems(Startup, set_window_icon)
        .add_plugins(HelloPlugin)
        .run();
}
