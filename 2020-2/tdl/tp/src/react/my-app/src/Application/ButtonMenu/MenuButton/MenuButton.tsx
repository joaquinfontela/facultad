import React from 'react'
import { MouseEventHandler } from 'react';
import "./MenuButton.css"

interface MenuButtonProps {
    text: string;
    onClick: MouseEventHandler;
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