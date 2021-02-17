import React from 'react'
import "./MenuButton.css"

interface MenuButtonProps {
    text: string;
    onClick: any;
    enabled: boolean
}

export class MenuButton extends React.Component<MenuButtonProps> {

    render(): JSX.Element {
        return (
            <div>
                <button className="menuButton" onClick={this.props.onClick} disabled={!this.props.enabled}>{this.props.text}</button>
            </div>
        );
    }
}