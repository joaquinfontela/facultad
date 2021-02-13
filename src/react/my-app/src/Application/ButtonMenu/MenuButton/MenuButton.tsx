import React from 'react'
import "./MenuButton.css"

interface MenuButtonProps {
    text: string;
}

export class MenuButton extends React.Component<MenuButtonProps> {

    render(): JSX.Element {
        return (
            <div>
                <button className="menuButton">{this.props.text}</button>
            </div>
        );
    }
}