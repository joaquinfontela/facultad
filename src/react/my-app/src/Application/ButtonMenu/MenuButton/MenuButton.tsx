import React from 'react'

interface MenuButtonProps {
    text: string;
}

export class MenuButton extends React.Component<MenuButtonProps> {

    render(): JSX.Element {
        return (
            <div>
                <button>{this.props.text}</button>
            </div>
        );
    }
}