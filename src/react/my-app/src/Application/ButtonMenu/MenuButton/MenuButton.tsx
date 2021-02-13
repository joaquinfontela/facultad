import React from 'react'
import "./MenuButton.css"

interface MenuButtonProps {
    text: string;
    onClick: any;
}

export class MenuButton extends React.Component<MenuButtonProps> {

    render(): JSX.Element {
        return (
            <div>
                <button className="menuButton" onClick={this.props.onClick}>{this.props.text}</button>
            </div>
        );
    }
}